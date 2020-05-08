package com.springcloud.demo.feign.service;

import com.springcloud.demo.common.util.Result;
import com.springcloud.demo.feign.entity.Client;
import com.springcloud.demo.feign.service.fallback.ClientFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 访问Client模块
 *
 * @author FLY
 * @date 2020-05-08 17:14
 */
@FeignClient(value = "springcloud-client", fallback = ClientFeignFallback.class)
public interface ClientFeignService {

    /**
     * 根据id获取client
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<Client> getClientById(@PathVariable("id") Integer id);
}
