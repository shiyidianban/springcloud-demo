package com.springcloud.demo.feign.dto;

import com.springcloud.demo.feign.entity.Client;
import com.springcloud.demo.feign.entity.Order;
import lombok.Data;

import java.util.List;

/**
 * @author FLY
 * @date 2020-05-11 9:39
 */
@Data
public class ClientDTO extends Client {

    List<Order> orderList;

}
