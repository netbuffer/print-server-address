package cn.netbuffer.printserveraddress.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;

public class SpringBootAppStartedListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        if(applicationContext.getParent()!=null){
            return;
        }
        Environment environment = applicationContext.getEnvironment();
        String serverPort = environment.getProperty("server.port") == null ? "" : ":" + environment.getProperty("server.port");
        String contextPath = environment.getProperty("server.context-path");
        if (contextPath == null || contextPath.trim().length() == 0) {
            contextPath = environment.getProperty("server.servlet.context-path");
        }
        contextPath = contextPath == null ? "/" : (contextPath.startsWith("/") ? contextPath : "/" + contextPath);
        System.out.println("your app started,access http://localhost" + serverPort + contextPath);
    }
}
