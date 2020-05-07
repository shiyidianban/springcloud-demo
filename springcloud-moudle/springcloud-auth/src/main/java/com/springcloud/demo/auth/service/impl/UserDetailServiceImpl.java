package com.springcloud.demo.auth.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.springcloud.demo.auth.entity.SysMenu;
import com.springcloud.demo.auth.entity.SysRole;
import com.springcloud.demo.auth.entity.SysUser;
import com.springcloud.demo.auth.service.SysMenuService;
import com.springcloud.demo.auth.service.SysRoleService;
import com.springcloud.demo.auth.service.SysUserService;
import com.springcloud.demo.auth.service.UserDetailsService;
import com.springcloud.demo.common.exception.ServiceException;
import com.springcloud.demo.common.util.ObjectUtils;
import com.springcloud.demo.common.util.RedisHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用户信息服务，实现 Spring Security的UserDetailsService接口方法，用于身份认证
 *
 * @author FLY
 * @date 2020-05-07 14:17
 */
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService userService;

    @Autowired
    private SysRoleService roleService;

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private RedisHelper redisHelper;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        // 可用性 :true:可用 false:不可用
        boolean enabled = true;
        // 过期性 :true:没过期 false:过期
        boolean accountNonExpired = true;
        // 有效性 :true:凭证有效 false:凭证无效
        boolean credentialsNonExpired = true;
        // 锁定性 :true:未锁定 false:已锁定
        boolean accountNonLocked = true;
        // 判断缓存中是否存在以该用户名为key的用户信息，如果有，则直接封装返回
        if (ObjectUtils.isNotNull(redisHelper.get(username))) {
            SysUser sysUser = JSONObject.parseObject(redisHelper.get(username), SysUser.class);
            return new User(sysUser.getUsername(), sysUser.getPassword(),
                    enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
        }

        // 从数据库中查询获取该账户信息
        SysUser sysUser = this.userService.findByUsername(username);
        if (ObjectUtils.isNull(sysUser)) {
            throw new ServiceException("用户:" + username + ",不存在!");
        }

        // 获取用户角色列表
        List<SysRole> roles = this.roleService.getRoleByUserId(sysUser.getId());
        if (!ObjectUtils.isNull(roles)) {
            for (SysRole role : roles) {
                // 角色必须是ROLE_开头，可以在数据库中设置
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getValue());
                grantedAuthorities.add(grantedAuthority);
                // 获取用户权限列表
                List<SysMenu> permissions = this.sysMenuService.getMenusByRoleId(role.getId());
                if (!ObjectUtils.isNull(permissions)) {
                    for (SysMenu menu : permissions) {
                        GrantedAuthority authority = new SimpleGrantedAuthority(menu.getCode());
                        grantedAuthorities.add(authority);
                    }
                }
            }
        }

        redisHelper.set(username, JSONObject.toJSONString(sysUser));
        return null;
    }
}
