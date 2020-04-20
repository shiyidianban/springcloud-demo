package com.springcloud.demo.gateway.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

/**
 * 过滤器工厂-GatewayFilterFactory，实现自定义过滤器配置
 *
 * @author FLY
 * @date 2020-04-20 15:52
 */
@Slf4j
@Component
public class RequestTimeGatewayFilterFactory extends AbstractGatewayFilterFactory<RequestTimeGatewayFilterFactory.Config> {

    public RequestTimeGatewayFilterFactory() {
        super(Config.class);
    }
    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("enabled");
    }

    /**
     * 过滤器执行体
     *
     * @param config 配置文件
     * @return
     */
    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain)->{
            if(!config.isEnabled()){ //如果没有启用过滤器,则自动跳过
                return chain.filter(exchange);
            }

            exchange.getAttributes().put("startTime", System.currentTimeMillis());
            log.info("===================pre阶段====================");
            return chain.filter(exchange).then(
                    Mono.fromRunnable(() -> {
                        Long startTime = exchange.getAttribute("startTime");
                        if (startTime != null) {
                            log.info("=========post阶段==============，执行路径：{}，所耗时间：{}",exchange.getRequest().getURI().getRawPath(),(System.currentTimeMillis() - startTime) + "ms");
                        }
                    }));
        };
    }

    /**
     * 过滤器工厂在配置文件中的配置属性
     */
    public static class Config {
        // 控制是否开启认证
        private boolean enabled;
        public Config() {}

        public boolean isEnabled() {
            return enabled;
        }
        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }
    }
}
