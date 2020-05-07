package com.springcloud.demo.auth.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户信息服务
 *
 * @author FLY
 * @date 2020-05-07 14:17
 */
public interface UserDetailsService {

    /**
     * 根据用户名查找账户信息并返回用户信息实体
     *
     * @param username 用户名
     * @return 用于身份认证的 UserDetails 用户信息实体
     */
    UserDetails loadUserByUsername(String username);
}
