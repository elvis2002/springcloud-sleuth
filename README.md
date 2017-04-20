# 组件说明：Spring Cloud Sleuth

SLeuth是日志收集工具包，封装了Dapper和log-based追踪以及Zipkin和HTrace操作，为SpringCloud应用实现了一种分布式追踪解决方案。

## 创建sleuth server

* 创建一个mvn工程，起名为sleuth-server,其pom.xml见实例代码，核心依赖如下：

```
    
    <dependency>
        <groupId>io.zipkin</groupId>
        <artifactId>zipkin-ui</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>io.zipkin.java</groupId>
        <artifactId>zipkin-server</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-sleuth</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-sleuth-zipkin</artifactId>
    </dependency>
        
```

* 程序的入口Application类

```
    
    @SpringBootApplication
    @EnableZipkinServer
    public class ServerZipkinApplication {
    
        public static void main(String[] args) {
            SpringApplication.run(ServerZipkinApplication.class, args);
        }
    }

        
```

* 配置文件

```
    
    spring.application.name=sleuth-zipkin
    server.port=9411
        
```
    
* 访问地址

    http://DOCKER_HOST:DOCKER_PORT/
   

## 创建sleuth service

* 创建一个mvn工程，起名为sleuth-service,其pom.xml见实例代码，核心依赖如下：

```
    
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-sleuth</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-sleuth-zipkin</artifactId>
    </dependency>
        
```

* 配置文件

```
    
    spring.application.name=sleuth-service
    server.port=5000
    eureka.client.serviceUrl.defaultZone=http://${EUREKA_HOST}:${EUREKA_PORT}/eureka/
    eureka.instance.preferIpAddress=true
    spring.sleuth.sampler.percentage=100
    spring.sleuth.feign.enabled=true
    
    spring.zipkin.baseUrl=http://127.0.0.1:9411
    spring.zipkin.enabled=true
        
```
    
* 访问地址

    http://DOCKER_HOST:DOCKER_PORT/
    
    http://DOCKER_HOST:DOCKER_PORT/sleuth/index
    
