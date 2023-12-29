package com.solo.codegen.api.consts;

import com.solo.common.core.base.consts.BasicCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public enum CodeGenCode implements BasicCode {

    // 01数据源模块
    DATASOURCE_NAME_EXISTS(10101001, "DatasourceNameExists"),
    DATASOURCE_CONNECT_FAILED(10101002, "DatasourceConnectFailed"),

    // 02表模块

    // 03字段模块

    ;

    private final Integer code;
    private final String i18nKey;

}
