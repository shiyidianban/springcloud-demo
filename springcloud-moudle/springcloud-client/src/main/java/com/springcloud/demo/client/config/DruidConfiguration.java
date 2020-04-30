package com.springcloud.demo.client.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 整合实现Druid的SQL监控
 *
 * @author FLY
 * @date 2020-04-20 16:28
 */
@Configuration
public class DruidConfiguration {

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        //stat视图设置
        servletRegistrationBean.setServlet(new StatViewServlet());
        //对应路径映射
        servletRegistrationBean.addUrlMappings("/druid/*");
        Map<String, String> initParameters = new HashMap();
        // 登录监控页面的用户名
        initParameters.put("loginUsername", "admin");
        // 登录监控页面的密码
        initParameters.put("loginPassword", "admin");
        // 禁用HTML页面上的“Reset All”功能
        initParameters.put("resetEnable", "false");
        // IP白名单 (没有配置或者为空，则允许所有访问)
        initParameters.put("allow", "");
        // IP黑名单 (存在共同时，deny优先于allow),如果满足deny的话提示:Sorry, you are not permitted to view this page.
        initParameters.put("deny", "192.168.20.38");
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }
}
