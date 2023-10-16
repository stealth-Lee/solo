package com.solo.codegen.model.datasource.resp;

import lombok.Data;

/**
 * 数据源详情对象
 * @author 十一
 * @since 2023/10/09 11:18
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class DatasourceGetResp {

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

}
