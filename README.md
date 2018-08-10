# print-server-address
> use to print spring-boot app access address
### add to pom.xml
```
<repositories>
    <repository>
        <id>netbuffer-maven-master-repository</id>
        <name>netbuffer-maven-master-repository</name>
        <url>https://raw.githubusercontent.com/netbuffer/maven-repo/master/repository</url>
    </repository>
</repositories>
```
### create bean
```java
@Bean
public SpringBootAppStartedListener build() {
    return new SpringBootAppStartedListener();
}
```

# 微信扫码使用gitee工具
![gitee工具](https://s1.ax1x.com/2018/08/10/P60MMF.jpg)