package com.springcloud.demo.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springcloud.demo.auth.entity.SysMenu;
import com.springcloud.demo.auth.mapper.SysMenuMapper;
import com.springcloud.demo.auth.service.SysMenuService;
import com.springcloud.demo.common.util.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Override
    public List<SysMenu> getMenusByRoleIds(List<Integer> roleIds) {
        if (ObjectUtils.isNull(roleIds)) {
            return new ArrayList<>();
        }

        return this.baseMapper.getMenusByRoleIds(roleIds);
    }

    @Override
    public List<SysMenu> getMenusByRoleId(Integer id) {
        return this.getMenusByRoleIds(Collections.singletonList(id));
    }
}
