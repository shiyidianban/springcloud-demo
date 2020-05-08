package com.springcloud.demo.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author FLY
 * @date 2020-04-20 11:06
 */
@EnableEurekaClient
@EnableAuthorizationServer
@SpringBootApplication(scanBasePackages = {"com.springcloud.demo.auth", "com.springcloud.demo.common", "com.springcloud.demo.security"})
public class SpringCloudAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAuthApplication.class, args);
    }
}
