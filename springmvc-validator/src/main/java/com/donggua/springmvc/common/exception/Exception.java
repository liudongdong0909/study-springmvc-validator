package com.donggua.springmvc.common.exception;

import com.donggua.springmvc.common.bean.Result;
import com.donggua.springmvc.common.bean.ValidatorResult;
import com.donggua.springmvc.common.enums.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * 全局异常
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-14 下午 01:29
 */
@ControllerAdvice
@ResponseBody
public class Exception {

    public static final Logger LOGGER = LoggerFactory.getLogger(Exception.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        LOGGER.error("参数验证失败: ", exception);
        BindingResult bindingResult = exception.getBindingResult();

      /*  // 第一种:每次单个字段验证提示
        //String className = bindingResult.getObjectName();
        String field = bindingResult.getFieldError().getField();
        String message = bindingResult.getFieldError().getDefaultMessage();
        ValidatorResult result = new ValidatorResult(field, message);

        return ECPSResult.build(ECPSStatus.BAD_REQUEST_PARAMETER, result);*/

        //第二种: 一次多字段验证提示
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        List<ValidatorResult> results = new ArrayList<>();
        for (ObjectError error : allErrors) {
            //String className = error.getObjectName();
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            results.add(new ValidatorResult(field, message));
        }
        return Result.build(Status.BAD_REQUEST_PARAMETER, results);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        LOGGER.error("参数解析失败: ", exception);
        return Result.build(Status.BAD_REQUEST);
    }

    @ExceptionHandler(java.lang.Exception.class)
    public Result handleException(java.lang.Exception exception) {
        LOGGER.error("服务运行异常", exception);

        // 从ThreadLocal中获取当前的request 对象
        javax.servlet.http.HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        return Result.build(Status.ERROR);
    }

}
