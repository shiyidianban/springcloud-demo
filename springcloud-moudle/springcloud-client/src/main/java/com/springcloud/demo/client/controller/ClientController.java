package com.springcloud.demo.client.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springcloud.demo.client.entity.Client;
import com.springcloud.demo.client.service.ClientService;
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
        return clientService.addClient(client);
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
        return clientService.getClientById(id);
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
        return clientService.removeClient(id);
    }

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    @ApiOperation(value = "获取客户端分页列表", notes = "获取客户端分页列表", response = Client.class, responseContainer = "Item", produces = "application/json")
    @GetMapping("/page")
    public Result getClientPage(Page page) {
        return clientService.getClientPage(page);
    }

    /**
     * 自定义分页查询
     *
     * @param page
     * @return
     */
    @ApiOperation(value = "自定义分页查询", notes = "自定义分页查询", response = Client.class, responseContainer = "Item", produces = "application/json")
    @GetMapping("/pageAuto")
    public Result getClientPageAuto(Page page) {
        return Result.success(this.clientService.getClientPageAuto(page));
    }
}

