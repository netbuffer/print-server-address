package cn.netbuffer.printserveraddress.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;

public class SpringBootAppStartedListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Environment environment = contextRefreshedEvent.getApplicationContext().getEnvironment();
        String serverPort = environment.getProperty("server.port") == null ? "" : ":" + environment.getProperty("server.port");
        String contextPath = environment.getProperty("server.context-path") == null ? "/" : "/" + environment.getProperty("context-path");
        System.out.println("your app started,access http://localhost" + serverPort + contextPath);
    }
}
