package com.springcloud.demo.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springcloud.demo.auth.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author FLY
 * @since 2020-05-07
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 批量查询list
     *
     * @param roleIdList
     * @return
     */
    List<SysMenu> getMenusByRoleIds(@Param("roleIdList") List<Integer> roleIdList);


}
