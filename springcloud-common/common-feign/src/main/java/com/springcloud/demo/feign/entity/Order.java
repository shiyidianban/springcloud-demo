package com.springcloud.demo.feign.entity;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springcloud.demo.common.serializer.DateJsonDeserializer;
import com.springcloud.demo.common.serializer.DateJsonSerializer;
import lombok.Data;

import java.util.Date;

/**
 * 返回到前端的Order信息
 *
 * @author FLY
 * @date 2020-05-08 17:23
 */
@Data
public class Order {

    /**
     * 主键
     */
    private Integer id;

    private Integer clientId;

    private String orderNum;

    @JsonSerialize(using = DateJsonSerializer.class)
    @JsonDeserialize(using = DateJsonDeserializer.class)
    private Date createTime;

    @JsonSerialize(using = DateJsonSerializer.class)
    @JsonDeserialize(using = DateJsonDeserializer.class)
    private Date updateTime;

    private String createBy;

    private String updateBy;

    private Integer delFlag;

    private Client client;

}
