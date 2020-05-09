package com.springcloud.demo.feign.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springcloud.demo.common.serializer.DateJsonDeserializer;
import com.springcloud.demo.common.serializer.DateJsonSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author FLY
 * @since 2020-04-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonSerialize(using = DateJsonSerializer.class)
    @JsonDeserialize(using = DateJsonDeserializer.class)
    private Date createTime;

    /**
     * 最后更新时间
     */
    @JsonSerialize(using = DateJsonSerializer.class)
    @JsonDeserialize(using = DateJsonDeserializer.class)
    private Date updateTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 最后更新人
     */
    private String updateBy;
}
