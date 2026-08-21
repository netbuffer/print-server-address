# 🖨️ print-server-address

![Maven Central](https://img.shields.io/maven-central/v/cn.netbuffer/print-server-address)
![Version](https://img.shields.io/badge/version-4.0.0-blue)
![JDK](https://img.shields.io/badge/JDK-8%2B-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.x%20%7C%203.x%20%7C%204.x-brightgreen)
![License](https://img.shields.io/badge/License-Apache%202.0-blue)

> 🚀 一个轻量级的 Spring Boot 工具库 —— 应用启动完成后，自动在控制台打印项目的访问地址，再也不用翻日志猜端口了！

## ✨ 特性

- 🔌 **零配置接入** —— 引入依赖即生效，无需任何代码改动
- 🌐 **双地址输出** —— 同时打印 `localhost` 和局域网 IP 访问地址
- 🧩 **自动识别上下文** —— 自动读取 `server.port`、`server.servlet.context-path` 等配置
- 🎯 **只打印一次** —— 智能跳过子容器刷新事件，不会重复输出
- 🎨 **可定制装饰** —— 支持自定义打印内容的前后缀装饰符

## 📦 安装

```xml
<!-- https://mvnrepository.com/artifact/cn.netbuffer/print-server-address -->
<dependency>
    <groupId>cn.netbuffer</groupId>
    <artifactId>print-server-address</artifactId>
    <version>4.0.0</version>
</dependency>
```

## 📋 环境兼容性

| Spring Boot | JDK | 是否支持 |
|:-----------:|:---:|:--------:|
| 2.x         | 8+  | ✅ |
| 3.x         | 17+ | ✅ |
| 4.x         | 17+ | ✅ |

> 💡 单一 jar 全版本通用：同时提供 `spring.factories`（Boot 2.x）和 `AutoConfiguration.imports`（Boot 3.x/4.x）两种自动配置注册方式。

## 🚀 使用效果

启动应用后，控制台会输出：

```
▹▹▹▹▹▹▹▹ your app started,access [http://localhost:8080/, http://192.168.1.100:8080/] ◃◃◃◃◃◃◃◃
```

## 🔧 配置项

所有配置均为可选，通过 `application.yml` / `application.properties` 调整：

```yaml
print-server-address:
  prefix: "🚀🚀🚀"              # 打印内容前缀装饰，默认 ▹▹▹▹▹▹▹▹
  suffix: "✅✅✅"              # 打印内容后缀装饰，默认 ◃◃◃◃◃◃◃◃
  ignore-parent-context: false  # 为 true 时忽略父容器判断，子容器刷新时也会打印
```

| 配置项 | 说明 | 默认值 |
|--------|------|:------:|
| `prefix` | 输出前缀装饰符 | `▹▹▹▹▹▹▹▹` |
| `suffix` | 输出后缀装饰符 | `◃◃◃◃◃◃◃◃` |
| `ignore-parent-context` | 是否忽略父容器（Spring MVC 场景下根容器与子容器都会触发刷新事件） | `false` |

## ⚙️ 工作原理

1. 📡 监听 Spring 的 `ContextRefreshedEvent` 事件
2. 🔍 从 `Environment` 中读取 `server.port` 与 context-path 配置
3. 🏠 通过 `InetAddress.getLocalHost()` 获取本机局域网 IP
4. 🖨️ 组装并打印访问地址列表

## 📄 License

[Apache License 2.0](http://www.apache.org/licenses/LICENSE-2.0.txt)
