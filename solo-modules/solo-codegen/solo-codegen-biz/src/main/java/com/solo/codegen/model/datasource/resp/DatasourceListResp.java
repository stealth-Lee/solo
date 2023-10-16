package com.solo.codegen.model.datasource.resp;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 数据源列表对象
 * @author 十一
 * @since 2023/10/09 11:20
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class DatasourceListResp {

    /**
     * 数据源id
     */
    private Long sourceId;

    /**
     * 别名
     */
    private String name;

    /**
     * 数据源连接
     */
    private String url;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
