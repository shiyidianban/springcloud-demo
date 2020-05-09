package com.springcloud.demo.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.springcloud.demo.common.filter.UserInfoLocal;
import com.springcloud.demo.common.util.ConstantsUtil;
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
        Object createBy = metaObject.getValue(ConstantsUtil.CREATE_BY);
        Object createTime = metaObject.getValue(ConstantsUtil.CREATE_TIME);
        Object delFlag = metaObject.getValue(ConstantsUtil.DEL_FLAG);

        //设置当前登录用户，此处尚未开发权限系统，暂定admin
        if (null == createBy) {
            this.setFieldValByName(ConstantsUtil.CREATE_BY, UserInfoLocal.getUser().getToken(), metaObject);
        }

        if (null == createTime) {
            this.setFieldValByName(ConstantsUtil.CREATE_TIME, LocalDateTime.now(), metaObject);
        }

        //填充delFlag属性
        this.setFieldValByName(ConstantsUtil.DEL_FLAG, delFlagDefaultValue, metaObject);

        this.updateFill(metaObject);
    }

    /**
     * 更新填充
     *
     * @param metaObject 目标对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateBy = metaObject.getValue(ConstantsUtil.UPDATE_BY);
        Object updateTime = metaObject.getValue(ConstantsUtil.UPDATE_TIME);
        //设置当前登录用户，此处尚未开发权限系统，暂定admin
        if (null == updateBy) {
            this.setFieldValByName(ConstantsUtil.UPDATE_BY, UserInfoLocal.getUser().getToken(), metaObject);
        }

        if (null == updateTime) {
            this.setFieldValByName(ConstantsUtil.UPDATE_TIME, LocalDateTime.now(), metaObject);
        }
    }
}