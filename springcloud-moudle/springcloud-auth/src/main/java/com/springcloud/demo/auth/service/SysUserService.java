package com.springcloud.demo.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springcloud.demo.auth.entity.SysUser;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author FLY
 * @since 2020-05-07
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 获取用户信息
     *
     * @param username
     * @return
     */
    SysUser findByUsername(String username);
}
