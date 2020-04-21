package com.springcloud.demo.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 客户端
 *
 * @author FLY
 * @date 2020-04-20 11:06
 */
@EnableEurekaClient
@SpringBootApplication
public class SpringCloudModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudModuleApplication.class, args);
    }
}
