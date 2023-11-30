package solo.common.security.handler;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.dev33.satoken.exception.SameTokenInvalidException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.solo.common.core.constant.enums.GlobalErrorCode;
import com.solo.common.core.exception.ServiceException;
import com.solo.common.core.global.R;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 * @author Gentleman.Lee
 * @since 2023/09/11 11:11
 * 人生若只如初见，何事秋风悲画扇
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public R<?> handleException(Exception e) {
        log.error("[Exception] {}", e.getMessage(), e);
        return R.global(GlobalErrorCode.ERROR);
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(ServiceException.class)
    public R<?> handleServiceException(ServiceException e) {
        log.error("[ServiceException] {}", e.getMessage(), e);
        return R.global(e.getCode(), e.getMessage(), null);
    }

    /**
     * SpringMVC 参数校验不正确异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        assert fieldError != null;
        log.warn("[MethodArgumentNotValidException] {} : {}", fieldError.getField(), fieldError.getDefaultMessage());
        return R.global(GlobalErrorCode.BAD_REQUEST, String.format("%s:%s", GlobalErrorCode.BAD_REQUEST.message(), fieldError.getDefaultMessage()));
    }

    /**
     * SpringMVC 非法参数异常
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public R<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e, HttpServletRequest request) {
        log.warn("HttpMessageNotReadableException in ['{}'] : {}", request.getRequestURI(), e.getMessage());
        String erroMessage = null;
        Throwable cause = e.getCause();
        if (cause instanceof JsonMappingException) {
            JsonMappingException.Reference path = ((JsonMappingException) cause).getPath().get(0);
            Object value = ((InvalidFormatException) cause).getValue();
            String fieldName = path.getFieldName();
            erroMessage = String.format("无效参数值[%s:%s]", fieldName, value);
        }
        return R.global(GlobalErrorCode.BAD_REQUEST, String.format("%s:%s", GlobalErrorCode.BAD_REQUEST.message(), erroMessage));
    }

    /**
     * 处理 SpringMVC 参数绑定不正确，本质上也是通过 Validator 校验
     */
    @ExceptionHandler(BindException.class)
    public R<?> handleBindException(BindException ex) {
        log.warn("[handleBindException]", ex);
        FieldError fieldError = ex.getFieldError();
        assert fieldError != null; // 断言，避免告警
        return R.global(GlobalErrorCode.ERROR, String.format("请求参数不正确:%s", fieldError.getDefaultMessage()));
    }

    /**
     * 无效认证
     */
    @ExceptionHandler(SameTokenInvalidException.class)
    public R<Void> handleSameTokenInvalidException(SameTokenInvalidException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("[SameTokenInvalidException] -> [请求地址:'{}', 内网认证失败: {}]", requestURI, e.getMessage());
        return R.global(GlobalErrorCode.UNAUTHORIZED, "认证失败，无法访问系统资源");
    }

    /**
     * 认证失败
     */
    @ExceptionHandler(NotLoginException.class)
    public R<?> handleNotLoginException(NotLoginException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("[NotLoginException] -> [请求地址:'{}', 认证失败: {}]", requestURI, e.getMessage());
        return R.global(GlobalErrorCode.UNAUTHORIZED, "认证失败，无法访问系统资源");
    }

    /**
     * 角色权限异常
     * [NotRoleException] 请求地址:'/system/role/2', 没有访问权限: 无此角色：admin666
     * [NotRoleException] -> [请求地址:'/system/role/2', 没有访问权限: 无此角色：admin666]
     */
    @ExceptionHandler(NotRoleException.class)
    public R<?> handleNotRoleException(NotRoleException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("[NotRoleException] -> [请求地址:'{}', 没有访问权限: {}]", requestURI, e.getMessage());
        return R.global(GlobalErrorCode.FORBIDDEN, "没有访问权限，请联系管理员授权");
    }

    /**
     * 权限码异常
     */
    @ExceptionHandler(NotPermissionException.class)
    public R<?> handleNotPermissionException(NotPermissionException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("[NotPermissionException] -> [请求地址:'{}', 没有访问权限: {}]", requestURI, e.getMessage());
        return R.global(GlobalErrorCode.FORBIDDEN, "没有访问权限，请联系管理员授权");
    }

    /**
     * 自定义验证异常
     */
//    @ExceptionHandler(ConstraintViolationException.class)
//    public R<Void> constraintViolationException(ConstraintViolationException e) {
//        log.error(e.getMessage());
//        String message = StreamUtils.join(e.getConstraintViolations(), ConstraintViolation::getMessage, ", ");
//        return R.fail(message);
//    }

}
