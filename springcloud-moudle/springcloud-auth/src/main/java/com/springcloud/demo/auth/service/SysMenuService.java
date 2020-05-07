package com.springcloud.demo.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springcloud.demo.auth.entity.SysMenu;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author FLY
 * @since 2020-05-07
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 获取菜单列表
     *
     * @param ids
     * @return
     */
    List<SysMenu> getMenusByRoleIds(List<Integer> ids);

    /**
     * 获取菜单列表
     *
     * @param id
     * @return
     */
    List<SysMenu> getMenusByRoleId(Integer id);
}
