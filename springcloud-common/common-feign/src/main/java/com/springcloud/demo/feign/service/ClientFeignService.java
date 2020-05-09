package com.springcloud.demo.feign.service;

import com.springcloud.demo.common.util.ConstantsUtil;
import com.springcloud.demo.common.util.Result;
import com.springcloud.demo.feign.entity.Client;
import com.springcloud.demo.feign.service.fallback.ClientFeignFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * 访问Client模块
 *
 * @author FLY
 * @date 2020-05-08 17:14
 */
@FeignClient(value = "springcloud-client", fallback = ClientFeignFallbackImpl.class)
public interface ClientFeignService {

    /**
     * 根据id获取client
     *
     * @param token
     * @param id
     * @return
     */
    @GetMapping("client/{id}")
    Result<Client> getClientById(@RequestHeader(ConstantsUtil.TOKEN) String token, @PathVariable("id") Integer id);
}
