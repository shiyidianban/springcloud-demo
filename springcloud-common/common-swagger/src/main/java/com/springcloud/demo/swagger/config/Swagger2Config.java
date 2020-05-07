package com.springcloud.demo.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger
 *
 * @author FLY
 * @date 2020-05-07 11:24
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                // 增加api相关信息
                .apiInfo(apiInfo())
                // base，最终调用接口后会和paths拼接在一起
                .pathMapping("/")
                // 通过select函数可控制选择哪些接口允许暴露给swagger展示
                .select()
                // 指定扫描包进行接口展示限制
                .apis(RequestHandlerSelectors.basePackage("com.springcloud.demo.client.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 标题
                .title("springboot利用swagger构建api文档")
                // 描述
                .description("简单优雅的RestFull风格")
                // 服务条款网址
                .version("1.0")
                .build();
    }
}
