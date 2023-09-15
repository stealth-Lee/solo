package com.solo.system.api.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.solo.common.orm.base.entity.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户实体类
 * @author 十一
 * @since 2023/08/30 17:37
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@Table("sys_user")
public class SysUser extends BasicEntity {

    @Id(keyType = KeyType.Auto)
    private Long userId;
    private String username;
    private String password;

}
