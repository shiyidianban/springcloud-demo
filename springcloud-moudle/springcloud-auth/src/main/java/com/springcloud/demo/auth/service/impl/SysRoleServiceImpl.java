package com.springcloud.demo.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.demo.auth.entity.SysRole;
import com.springcloud.demo.auth.mapper.SysRoleMapper;
import com.springcloud.demo.auth.service.SysRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author FLY
 * @since 2020-05-07
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Override
    public List<SysRole> getRoleByUserId(Integer userId) {
        return this.baseMapper.getRoleByUserId(userId);
    }
}
