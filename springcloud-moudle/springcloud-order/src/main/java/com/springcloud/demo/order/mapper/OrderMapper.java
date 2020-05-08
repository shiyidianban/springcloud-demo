package com.springcloud.demo.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springcloud.demo.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author FLY
 * @since 2020-05-08
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
