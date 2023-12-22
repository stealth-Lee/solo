package com.solo.codegen.model.datasource.req;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 数据源新增对象
 * @author 十一
 * @since 2023/10/09 10:58
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class DatasourceCreateReq {

    /**
     * 别名
     */
    @NotEmpty(message = "{datasource.required.name}")
    @Size(message = "{datasource.size.name}", max = 64)
    private String name;

    /**
     * 数据源连接
     */
    @NotEmpty(message = "{datasource.required.url}")
    @Size(message = "{datasource.size.url}", max = 256)
    private String url;

    /**
     * 用户名
     */
    @NotEmpty(message = "{datasource.required.username}")
    @Size(message = "{datasource.size.username}", max = 64)
    private String username;

    /**
     * 密码
     */
    @NotEmpty(message = "{datasource.required.password}")
    @Size(message = "{datasource.size.password}", max = 64)
    private String password;

    /**
     * 备注
     */
    @Size(message = "{datasource.size.remark}", max = 512)
    private String remark;

}
