package com.springcloud.demo.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.demo.common.enums.RespEnum;
import com.springcloud.demo.common.filter.UserInfoLocal;
import com.springcloud.demo.common.util.Result;
import com.springcloud.demo.feign.dto.OrderDTO;
import com.springcloud.demo.feign.entity.Client;
import com.springcloud.demo.feign.service.ClientFeignService;
import com.springcloud.demo.order.entity.Order;
import com.springcloud.demo.order.mapper.OrderMapper;
import com.springcloud.demo.order.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author FLY
 * @since 2020-05-08
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private ClientFeignService clientFeignService;

    @Override
    public Result addOrder(Order order) {
        if (this.save(order)) {
            return Result.success(order.getId());
        } else {
            return Result.restResult(RespEnum.FAILED);
        }
    }

    @Override
    public Result getOrderById(Integer id) {
        Order order = this.getById(id);
        if (order == null) {
            return Result.success();
        }

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(order, orderDTO);
        Result<Client> result = clientFeignService.getClientById(UserInfoLocal.getUser().getToken(), orderDTO.getClientId());
        if (result == null || result.getCode() != RespEnum.SUCCESS.getCode()) {
            return Result.success(orderDTO);
        }

        orderDTO.setClient(result.getData());
        return Result.success(orderDTO);
    }

    @Override
    public Result removeOrder(Integer id) {
        if (this.removeById(id)) {
            return Result.success(id);
        } else {
            return Result.restResult(RespEnum.FAILED);
        }
    }

    @Override
    public Result getOrderPage(Page page, Order order) {
        return Result.success(this.page(page, new QueryWrapper<>(order)));
    }
}
