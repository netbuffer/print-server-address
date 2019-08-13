package cn.netbuffer.printserveraddress.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "print-server-address")
public class PrintServerAddressProperties {

    private String prefix="▹▹▹▹▹▹▹▹";
    private String suffix="◃◃◃◃◃◃◃◃";
    private boolean ignoreParentContext=false;

}