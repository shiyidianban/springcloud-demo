package com.springcloud.demo.client.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springcloud.demo.client.entity.Client;
import com.springcloud.demo.client.service.ClientService;
import com.springcloud.demo.common.util.ObjectUtils;
import com.springcloud.demo.common.util.RedisHelper;
import com.springcloud.demo.common.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author FLY
 * @since 2020-04-30
 */
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private RedisHelper redisHelper;

    /**
     * 新增client
     *
     * @param client client对象
     * @return
     */
    @PostMapping
    public Result addClient(@RequestBody Client client) {
        this.clientService.save(client);
        //填充缓存，key为client_${id}
        this.redisHelper.set("client_"+client.getId(), JSONObject.toJSONString(client));
        return Result.success(Boolean.TRUE);
    }

    /**
     * 根据id获取client
     *
     * @param id client的id
     * @return
     */
    @GetMapping("/{id}")
    public Result getClientById(@PathVariable Integer id) {
        // 首先从缓存获取
        Client client = JSONObject.parseObject(this.redisHelper.get("client_"+id), Client.class);
        if(ObjectUtils.isNotNull(client)){
            return Result.success(client);
        }

        return Result.success(this.clientService.getById(id));
    }

    /**
     * 根据id删除client
     *
     * @param id client的id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result removeClient(@PathVariable Integer id) {
        return Result.success(this.clientService.removeById(id));
    }

    /**
     * 分页查询
     *
     * @param page
     * @param client
     * @return
     */
    @GetMapping("/page")
    public Result getClientPage(Page page, Client client) {
        return Result.success(this.clientService.page(page, new QueryWrapper<>(client)));
    }

    /**
     * 自定义分页查询
     *
     * @param page
     * @param client
     * @return
     */
    @GetMapping("/pageAuto")
    public Result getClientPageAuto(Page page, Client client) {
        return Result.success(this.clientService.getClientPageAuto(page, client));
    }
}

