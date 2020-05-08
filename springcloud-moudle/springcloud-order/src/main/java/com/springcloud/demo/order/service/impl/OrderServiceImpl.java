package com.springcloud.demo.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.demo.common.enums.RespEnum;
import com.springcloud.demo.common.util.Result;
import com.springcloud.demo.order.entity.Order;
import com.springcloud.demo.order.mapper.OrderMapper;
import com.springcloud.demo.order.service.OrderService;
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

    @Override
    public Result addClient(Order order) {
        if (this.save(order)) {
            return Result.success(order.getId());
        } else {
            return Result.restResult(RespEnum.FAILED);
        }
    }

    @Override
    public Result getClientById(Integer id) {
        return Result.success(this.getById(id));
    }

    @Override
    public Result removeClient(Integer id) {
        if (this.removeById(id)) {
            return Result.success(id);
        } else {
            return Result.restResult(RespEnum.FAILED);
        }
    }

    @Override
    public Result getClientPage(Page page, Order order) {
        return Result.success(this.page(page, new QueryWrapper<>(order)));
    }
}
