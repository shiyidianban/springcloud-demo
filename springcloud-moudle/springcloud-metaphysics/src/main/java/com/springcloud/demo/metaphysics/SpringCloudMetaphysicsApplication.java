package com.springcloud.demo.metaphysics;

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
@SpringBootApplication(scanBasePackages = {"com.springcloud.demo.metaphysics", "com.springcloud.demo.common"})
public class SpringCloudMetaphysicsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudMetaphysicsApplication.class, args);
    }
}
