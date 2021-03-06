package com.springcloud.demo.feign.service.fallback;

import com.springcloud.demo.common.enums.RespEnum;
import com.springcloud.demo.common.util.Result;
import com.springcloud.demo.feign.service.ClientFeignService;
import org.springframework.stereotype.Component;

/**
 * 处理Client模块返回结果
 *
 * @author FLY
 * @date 2020-05-08 17:15
 */
@Component
public class ClientFeignFallbackImpl implements ClientFeignService {

    @Override
    public Result getClientById(String token, Integer id) {
        return Result.failed(RespEnum.FAILED);
    }
}
