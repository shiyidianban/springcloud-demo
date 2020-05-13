package com.springcloud.demo.zuul;

import com.springcloud.demo.zuul.config.WhiteListProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 启动配置
 *
 * @author FLY
 * @date 2020-05-13 13:59
 */
@EnableZuulProxy
@SpringBootApplication
@EnableConfigurationProperties(WhiteListProperties.class)
public class SpringCloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulApplication.class, args);
    }
}
