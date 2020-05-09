package com.springcloud.demo.client.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springcloud.demo.common.serializer.DateJsonDeserializer;
import com.springcloud.demo.common.serializer.DateJsonSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
@TableName("client")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Client", description = "客户端实体")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "客户端id", dataType = "Integer", name = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 客户端名称
     */
    @ApiModelProperty(value = "客户端名称", dataType = "String ", name = "clientName", required = true)
    @TableField("client_name")
    private String clientName;

    /**
     * 客户端路径
     */
    @ApiModelProperty(value = "客户端路径", dataType = "String ", name = "clientPath", required = true)
    @TableField("client_path")
    private String clientPath;

    /**
     * 逻辑删除标志
     */
    @ApiModelProperty(value = "逻辑删除标志", dataType = "Integer ", name = "delFlag")
    @TableField(value = "del_flag", fill = FieldFill.INSERT)
    @TableLogic
    private Integer delFlag;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", dataType = "Date ", name = "createTime")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonSerialize(using = DateJsonSerializer.class)
    @JsonDeserialize(using = DateJsonDeserializer.class)
    private Date createTime;

    /**
     * 最后更新时间
     */
    @ApiModelProperty(value = "最后更新时间", dataType = "LocalDateTime ", name = "updateTime")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    @JsonSerialize(using = DateJsonSerializer.class)
    @JsonDeserialize(using = DateJsonDeserializer.class)
    private Date updateTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人", dataType = "String ", name = "createBy")
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 最后更新人
     */
    @ApiModelProperty(value = "最后更新人", dataType = "String ", name = "updateBy")
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private String updateBy;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPath() {
        return clientPath;
    }

    public void setClientPath(String clientPath) {
        this.clientPath = clientPath;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
