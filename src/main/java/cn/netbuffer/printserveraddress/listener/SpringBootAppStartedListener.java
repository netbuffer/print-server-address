package cn.netbuffer.printserveraddress.listener;

import cn.netbuffer.printserveraddress.config.PrintServerAddressProperties;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Data
public class SpringBootAppStartedListener implements ApplicationListener<ContextRefreshedEvent> {

    private PrintServerAddressProperties printServerAddressProperties;

    public SpringBootAppStartedListener(PrintServerAddressProperties printServerAddressProperties) {
        this.printServerAddressProperties = printServerAddressProperties;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        if (applicationContext.getParent() != null) {
            return;
        }
        Environment environment = applicationContext.getEnvironment();
        String serverPort = environment.getProperty("server.port") == null ? "" : ":" + environment.getProperty("server.port");
        String contextPath = environment.getProperty("server.context-path");
        if (contextPath == null || contextPath.trim().length() == 0) {
            contextPath = environment.getProperty("server.servlet.context-path");
        }
        contextPath = contextPath == null ? "/" : (contextPath.startsWith("/") ? contextPath : "/" + contextPath);
        String lanIp = null;
        try {
            lanIp = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            System.out.println(e.getLocalizedMessage());
        }
        List addresses = new ArrayList(2);
        addresses.add("http://localhost" + serverPort + contextPath);
        if (!StringUtils.isEmpty(lanIp)) {
            addresses.add("http://" + lanIp + serverPort + contextPath);
        }
        System.out.println(printServerAddressProperties.getPrefix() + " your app started,access " + addresses.toString() + " " + printServerAddressProperties.getSuffix());
    }
}
