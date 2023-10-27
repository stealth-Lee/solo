package com.solo.codegen.model.code.resp;

import lombok.Data;

/**
 * 代码预览响应类
 * @author 十一
 * @since 2023/10/26 15:07
 * 人生若只如初见，何事秋风悲画扇
 **/
@Data
public class CodePreviewResp {

    /**
     * 代码文件路径
     */
    private String path;

    /**
     * 代码内容
     */
    private String code;

}
