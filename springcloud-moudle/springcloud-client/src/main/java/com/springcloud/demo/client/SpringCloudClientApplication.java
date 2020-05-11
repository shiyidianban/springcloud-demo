package com.springcloud.demo.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 客户端
 *
 * @author FLY
 * @date 2020-04-20 11:06
 */
@EnableEurekaClient
@EnableFeignClients(value = {"com.springcloud.demo.feign"})
@SpringBootApplication(scanBasePackages = {"com.springcloud.demo.client", "com.springcloud.demo.common", "com.springcloud.demo.swagger", "com.springcloud.demo.feign"})
public class SpringCloudClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudClientApplication.class, args);
    }
}
