package com.springcloud.demo.order.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springcloud.demo.common.util.Result;
import com.springcloud.demo.order.entity.Order;
import com.springcloud.demo.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author FLY
 * @since 2020-05-08
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 新增
     */
    @PostMapping
    public Result addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    /**
     * 根据id获取order
     *
     * @param id order的id
     * @return
     */
    @GetMapping("/{id}")
    public Result getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    /**
     * 根据id删除client
     *
     * @param id client的id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result removeOrder(@PathVariable Integer id) {
        return orderService.removeOrder(id);
    }

    /**
     * 分页查询
     *
     * @param page
     * @param order
     * @return
     */
    @GetMapping("/page")
    public Result getOrderPage(Page page, Order order) {
        return orderService.getOrderPage(page, order);
    }

    /**
     * 根据模块获取订单列表
     *
     * @param clientId
     * @return
     */
    @GetMapping("/orderListByClientId")
    public Result getOrderListByClientId(Integer clientId) {
        return orderService.getOrderListByClientId(clientId);
    }
}

