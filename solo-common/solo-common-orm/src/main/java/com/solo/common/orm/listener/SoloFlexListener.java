package com.solo.common.orm.listener;

import com.mybatisflex.annotation.InsertListener;
import com.mybatisflex.annotation.UpdateListener;
import com.solo.common.core.base.entity.BasicEntity;
import com.solo.satoken.utils.LoginHelper;

import java.time.LocalDateTime;

/**
 * mybatis-flex 自动填充监听器
 * @author 十一
 * @since 2023/09/08 17:20
 * 人生若只如初见，何事秋风悲画扇
 **/
public class SoloFlexListener implements InsertListener, UpdateListener {

    /**
     * 插入监听
     * @param entity 插入对象
     */
    @Override
    public void onInsert(Object entity) {
        BasicEntity basicEntity = (BasicEntity) entity;
        basicEntity.setDeleted(false);
        basicEntity.setCreateBy(LoginHelper.getUserId().toString());
        basicEntity.setCreateTime(LocalDateTime.now());
    }

    /**
     * 更新监听
     * @param entity 更新对象
     */
    @Override
    public void onUpdate(Object entity) {
        BasicEntity basicEntity = (BasicEntity) entity;
        basicEntity.setUpdateBy(LoginHelper.getUserId().toString());
        basicEntity.setUpdateTime(LocalDateTime.now());
    }

}
