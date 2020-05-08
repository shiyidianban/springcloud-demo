package com.springcloud.demo.feign.entity;


import lombok.Data;

import java.time.LocalDateTime;

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

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String createBy;

    private String updateBy;

    private Integer delFlag;

    private Client client;

}
