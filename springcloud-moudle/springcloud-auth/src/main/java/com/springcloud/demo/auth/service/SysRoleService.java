package com.springcloud.demo.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springcloud.demo.auth.entity.SysRole;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author FLY
 * @since 2020-05-07
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 获取角色列表信息
     *
     * @param id
     * @return
     */
    List<SysRole> getRoleByUserId(Integer id);
}
