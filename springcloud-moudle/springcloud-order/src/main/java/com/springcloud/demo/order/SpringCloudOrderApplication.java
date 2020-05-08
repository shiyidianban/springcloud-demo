package com.springcloud.demo.order;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * o
 *
 * @author FLY
 * @date 2020-05-08 14:11
 */
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.springcloud.demo.order", "com.springcloud.demo.common"})
public class SpringCloudOrderApplication {
}
