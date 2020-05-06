package com.springcloud.demo.client.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springcloud.demo.client.entity.Client;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author FLY
 * @since 2020-04-30
 */
public interface ClientService extends IService<Client> {

    /**
     * 自定义分页查询
     *
     * @param page   分页对象
     * @param client 传入对象参数
     * @return
     */
    public IPage<Client> getClientPageAuto(Page page, Client client);

}
