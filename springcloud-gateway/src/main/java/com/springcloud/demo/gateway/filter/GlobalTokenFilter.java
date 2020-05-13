package com.springcloud.demo.gateway.filter;

import com.springcloud.demo.common.enums.RespEnum;
import com.springcloud.demo.common.util.ConstantsUtil;
import com.springcloud.demo.common.util.ObjectUtils;
import com.springcloud.demo.common.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 全局过滤器
 *
 * @author FLY
 * @date 2020-04-20 15:31
 */
@Slf4j
@Component //将GlobalTokenFilter注册成bean方可生效
public class GlobalTokenFilter implements GlobalFilter, Ordered {

    /**
     * 过滤器执行体
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 获取token
        List tokenList = exchange.getRequest().getHeaders().get(ConstantsUtil.TOKEN);
        if (ObjectUtils.isNull(tokenList)) {
            log.error(Result.failed(RespEnum.NO_LOGIN).toString());
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            exchange.getResponse().getHeaders().set("Content-Type", "application/json;charset=UTF-8");
            return exchange.getResponse().writeWith(Flux.just(exchange.getResponse().bufferFactory().wrap(Result.failed(RespEnum.NO_LOGIN).toString().getBytes())));
        }

        //  继续执行下一过滤器/调用接口
        return chain.filter(exchange);
    }

    /**
     * 设置当前过滤器的优先级，值越大，优先级越低
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
