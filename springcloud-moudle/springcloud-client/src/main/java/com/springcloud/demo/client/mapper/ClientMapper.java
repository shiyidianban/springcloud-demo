package com.springcloud.demo.client.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    /**
     * 自定义分页查询
     *
     * @param page   分页对象
     * @return
     */
    IPage<Client> selectClientPage(Page page);

}
