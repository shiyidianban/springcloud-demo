package com.springcloud.demo.client.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springcloud.demo.client.entity.Client;
import com.springcloud.demo.common.util.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
     * 新增client
     *
     * @param client client对象
     * @return
     */
    Result addClient(@RequestBody Client client);

    /**
     * 根据id获取client
     *
     * @param id client的id
     * @return
     */
    Result getClientById(@PathVariable Integer id);

    /**
     * 根据id删除client
     *
     * @param id client的id
     * @return
     */
    Result removeClient(@PathVariable Integer id);

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    Result getClientPage(Page page);

    /**
     * 自定义分页查询
     *
     * @param page   分页对象
     * @param client 传入对象参数
     * @return
     */
    IPage<Client> getClientPageAuto(Page page);

}
