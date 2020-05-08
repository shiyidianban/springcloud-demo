package com.springcloud.demo.order.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springcloud.demo.common.util.Result;
import com.springcloud.demo.order.entity.Order;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author FLY
 * @since 2020-05-08
 */
public interface OrderService extends IService<Order> {

    /**
     * 新增
     *
     * @param order
     * @return
     */
    Result addClient(Order order);

    /**
     * 根据id获取order
     *
     * @param id order的id
     * @return
     */
    Result getClientById(Integer id);

    /**
     * 根据id删除client
     *
     * @param id client的id
     * @return
     */
    Result removeClient(Integer id);

    /**
     * 分页查询
     *
     * @param page
     * @param order
     * @return
     */
    Result getClientPage(Page page, Order order);

}
