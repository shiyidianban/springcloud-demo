package com.springcloud.demo.feign.service;

import com.springcloud.demo.common.util.ConstantsUtil;
import com.springcloud.demo.common.util.Result;
import com.springcloud.demo.feign.entity.Order;
import com.springcloud.demo.feign.service.fallback.OrderFeignFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 访问Order模块
 *
 * @author FLY
 * @date 2020-05-11 9:28
 */
@FeignClient(value = "springcloud-order", fallback = OrderFeignFallbackImpl.class)
public interface OrderFeignService {

    /**
     * 根据id获取Order
     *
     * @param token
     * @param clientId
     * @return
     */
    @GetMapping("/order/orderListByClientId")
    Result<List<Order>> getOrderListByClientId(@RequestHeader(ConstantsUtil.TOKEN) String token, @RequestParam("clientId") Integer clientId);
}
