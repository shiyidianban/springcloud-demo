package com.springcloud.demo.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author FLY
 * @since 2020-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_menu")
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 菜单编码
     */
    @TableField("code")
    private String code;

    /**
     * 菜单父编码
     */
    @TableField("p_code")
    private String pCode;

    /**
     * 父菜单ID
     */
    @TableField("p_id")
    private String pId;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 请求地址
     */
    @TableField("url")
    private String url;

    /**
     * 是否是菜单(1.菜单。2.按钮)
     */
    @TableField("is_menu")
    private Integer isMenu;

    /**
     * 菜单层级
     */
    @TableField("level")
    private Integer level;

    /**
     * 菜单排序
     */
    @TableField("sort")
    private Integer sort;

    /**
     * 菜单状态（是否激活）
     */
    @TableField("status")
    private Integer status;

    /**
     * 是否删除
     */
    @TableField("del_flag")
    private Integer delFlag;

    /**
     * 菜单图标
     */
    @TableField("icon")
    private String icon;

    /**
     * 创建者
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 最后更新者
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 最后更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;


}
