package com.springcloud.demo.client.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 填充处理器
 *
 * @author FLY
 * @date 2020-05-06 17:42
 */
@Component
public class MpMetaObjectHandler implements MetaObjectHandler {

    @Value("${mybatis-plus.global-config.db-config.logic-not-delete-value}")
    private Integer delFlagDefaultValue;

    /**
     * 插入填充
     *
     * @param metaObject 目标对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Object createBy = metaObject.getValue("createBy");
        Object createTime = metaObject.getValue("createTime");
        Object delFlag = metaObject.getValue("delFlag");

        //设置当前登录用户，此处尚未开发权限系统，暂定admin
        if (null == createBy) {
            this.setFieldValByName("createBy", "admin", metaObject);
        }

        if (null == createTime) {
            this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        }

        //填充delFlag属性
        this.setFieldValByName("delFlag", delFlagDefaultValue, metaObject);

        this.updateFill(metaObject);
    }

    /**
     * 更新填充
     *
     * @param metaObject 目标对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateBy = metaObject.getValue("updateBy");
        Object updateTime = metaObject.getValue("updateTime");
        //设置当前登录用户，此处尚未开发权限系统，暂定admin
        if (null == updateBy) {
            this.setFieldValByName("updateBy", "admin", metaObject);
        }

        if (null == updateTime) {
            this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        }
    }
}