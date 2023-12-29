package com.solo.common.orm.exception;

import com.solo.common.core.base.exception.BasicException;

/**
 * 未找到注解异常
 * @author 十一
 * @since 2023/09/19 10:18
 * 人生若只如初见，何事秋风悲画扇
 **/
public class NotFoundAnnoException extends BasicException {

    // TODO 此处code码需重新考虑
    public NotFoundAnnoException(String module, String message) {
        super(module, 400100, message);
    }

}
