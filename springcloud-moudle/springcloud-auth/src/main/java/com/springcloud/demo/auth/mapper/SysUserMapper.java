package com.springcloud.demo.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springcloud.demo.auth.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author FLY
 * @since 2020-05-07
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}
