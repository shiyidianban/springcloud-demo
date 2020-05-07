package com.springcloud.demo.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springcloud.demo.auth.entity.SysRole;
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
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 查询用户角色信息
     *
     * @param userId 用户Id
     * @return 角色信息
     */
    List<SysRole> getRoleByUserId(@Param("userId") int userId);

}
