package com.springcloud.demo.client.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.demo.client.entity.Client;
import com.springcloud.demo.client.mapper.ClientMapper;
import com.springcloud.demo.client.service.ClientService;
import com.springcloud.demo.common.enums.RespEnum;
import com.springcloud.demo.common.filter.UserInfoLocal;
import com.springcloud.demo.common.util.ObjectUtils;
import com.springcloud.demo.common.util.RedisHelper;
import com.springcloud.demo.common.util.Result;
import com.springcloud.demo.feign.dto.ClientDTO;
import com.springcloud.demo.feign.entity.Order;
import com.springcloud.demo.feign.service.OrderFeignService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author FLY
 * @since 2020-04-30
 */
@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements ClientService {

    @Autowired
    OrderFeignService orderFeignService;

    @Autowired
    private RedisHelper redisHelper;

    /**
     * 新增client
     *
     * @param client client对象
     * @return
     */
    @Override
    public Result addClient(@RequestBody Client client) {
        if (this.save(client)) {
            //填充缓存，key为client_${id}
            this.redisHelper.set("client_" + client.getId(), JSONObject.toJSONString(client));
            return Result.success(client.getId());
        } else {
            return Result.failed(RespEnum.FAILED);
        }
    }

    /**
     * 根据id获取client
     *
     * @param id client的id
     * @return
     */
    @Override
    public Result getClientById(@PathVariable Integer id) {
        // 首先从缓存获取
        Client client = JSONObject.parseObject(this.redisHelper.get("client_" + id), Client.class);
        if (ObjectUtils.isNull(client)) {
            client = this.getById(id);
        }

        if (ObjectUtils.isNull(client)) {
            return Result.success();
        }

        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        Result<List<Order>> result = orderFeignService.getOrderListByClientId(UserInfoLocal.getUser().getToken(), client.getId());
        clientDTO.setOrderList(result.getData());
        return Result.success(clientDTO);
    }

    /**
     * 根据id删除client
     *
     * @param id client的id
     * @return
     */
    @Override
    public Result removeClient(@PathVariable Integer id) {
        if (this.removeById(id)) {
            return Result.success(id);
        } else {
            return Result.failed(RespEnum.FAILED);
        }
    }

    /**
     * 分页查询
     *
     * @param page
     * @param client
     * @return
     */
    @Override
    public Result getClientPage(Page page, Client client) {
        return Result.success(this.page(page, new QueryWrapper<>(client)));
    }

    @Override
    public IPage<Client> getClientPageAuto(Page page, Client client) {
        return this.baseMapper.selectClientPage(page, client);
    }
}
