package com.springcloud.demo.client.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springcloud.demo.client.entity.Client;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author FLY
 * @since 2020-04-30
 */
@Mapper
public interface ClientMapper extends BaseMapper<Client> {

}
