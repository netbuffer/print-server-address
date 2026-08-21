package cn.netbuffer.printserveraddress.autoconfig;

import cn.netbuffer.printserveraddress.config.PrintServerAddressProperties;
import cn.netbuffer.printserveraddress.listener.SpringBootAppStartedListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@ConditionalOnClass(SpringBootAppStartedListener.class)
@EnableConfigurationProperties(PrintServerAddressProperties.class)
public class PrintServerAddressConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SpringBootAppStartedListener buildSpringBootAppStartedListener(PrintServerAddressProperties printServerAddressProperties) {
        return new SpringBootAppStartedListener(printServerAddressProperties);
    }

}