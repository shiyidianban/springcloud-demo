package com.springcloud.demo.feign.dto;


import com.springcloud.demo.feign.entity.Client;
import com.springcloud.demo.feign.entity.Order;
import lombok.Data;

/**
 * 返回到前端的Order信息
 *
 * @author FLY
 * @date 2020-05-08 17:23
 */
@Data
public class OrderDTO extends Order {

    private Client client;
}
