package com.springcloud.demo.client.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springcloud.demo.client.entity.Client;
import com.springcloud.demo.client.service.ClientService;
import com.springcloud.demo.common.util.ObjectUtils;
import com.springcloud.demo.common.util.RedisHelper;
import com.springcloud.demo.common.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "客户端模块前端控制器", tags = {"client"})
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
    @ApiOperation(value = "添加客户端", notes = "添加客户端", response = Result.class, responseContainer = "Item", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "client", value = "客户端实体", required = true, dataType = "Client", paramType = "body"),
    })
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
    @ApiOperation(value = "获取客户端信息", notes = "获取客户端信息", response = Client.class, responseContainer = "Item", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "客户端id", required = true, dataType = "Long", paramType = "path")
    })
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
    @ApiOperation(value = "删除客户端信息", notes = "删除客户端信息", response = Client.class, responseContainer = "Item", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "客户端id", required = true, dataType = "Long", paramType = "path")
    })
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
    @ApiOperation(value = "获取客户端分页列表", notes = "获取客户端分页列表", response = Client.class, responseContainer = "Item", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页码", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "当前页最大显示条数", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "client", value = "客户端对象", required = true, dataType = "Client", paramType = "query")
    })
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
    @ApiOperation(value = "自定义分页查询", notes = "自定义分页查询", response = Client.class, responseContainer = "Item", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页码", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "当前页最大显示条数", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "client", value = "客户端对象", required = true, dataType = "Client", paramType = "query")
    })
    @GetMapping("/pageAuto")
    public Result getClientPageAuto(Page page, Client client) {
        return Result.success(this.clientService.getClientPageAuto(page, client));
    }
}

