package com.springcloud.demo.feign.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author FLY
 * @since 2020-04-30
 */
@Data
public class Client implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 客户端名称
     */
    private String clientName;

    /**
     * 客户端路径
     */
    private String clientPath;

    /**
     * 逻辑删除标志
     */
    private Integer delFlag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 最后更新人
     */
    private String updateBy;
}
