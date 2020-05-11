package com.springcloud.demo.feign.service.fallback;

import com.springcloud.demo.common.enums.RespEnum;
import com.springcloud.demo.common.util.Result;
import com.springcloud.demo.feign.entity.Order;
import com.springcloud.demo.feign.service.OrderFeignService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 处理Order错误返回结果
 *
 * @author FLY
 * @date 2020-05-11 9:31
 */
@Component
public class OrderFeignFallbackImpl implements OrderFeignService {

    @Override
    public Result<List<Order>> getOrderListByClientId(String token, Integer clientId) {
        return Result.restResult(RespEnum.FAILED);
    }
}
