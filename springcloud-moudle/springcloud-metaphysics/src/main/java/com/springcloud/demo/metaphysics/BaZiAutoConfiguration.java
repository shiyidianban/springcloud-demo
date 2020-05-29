package com.springcloud.demo.metaphysics;

import com.springcloud.demo.metaphysics.utils.BaZiService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author FLY
 * @date 2020-05-29 17:00
 */
@Configuration
public class BaZiAutoConfiguration {

    @Bean
    public BaZiService baZiService() {
        BaZiService baZiService = new BaZiService();
        return baZiService;
    }
}
