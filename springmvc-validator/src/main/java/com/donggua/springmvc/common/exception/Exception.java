package com.donggua.springmvc.common.exception;

import com.donggua.springmvc.common.bean.Result;
import com.donggua.springmvc.common.bean.ValidatorResult;
import com.donggua.springmvc.common.enums.Status;
import com.donggua.springmvc.common.util.ValidatorUtils;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
public class Exception extends Throwable {

    public static final Logger LOGGER = LoggerFactory.getLogger(Exception.class);

    /**
     * 服务器运行异常 - 500
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(java.lang.Exception.class)
    public Result handleException(java.lang.Exception exception) {
        LOGGER.error("服务运行异常", exception);

        return Result.build(Status.ERROR);
    }

    /**
     * Content-Type 类型错误 - 415
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    public Result handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException exception) {
        LOGGER.error("不支持当前 Content-Type 类型", exception);

        return Result.build(Status.UNSUPPORTED_MEDIA_TYPE);
    }

    /**
     * 不支持当前请求方法 - 405
     * @param exception
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public Result handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {

        LOGGER.error("不支持当前请求方法", exception);
        return Result.build(Status.METHOD_NOT_ALLOWED);
    }


    /**
     * 请求不存在 - 404
     *
     * @param exception
     * @return
     */
   /* @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public Result handleNotFoundException(ResourceNotFoundException exception) {
        LOGGER.error("请求不存在", exception);
        return Result.build(Status.NOT_FOUND);
    }*/


    /**
     * 参数提交格式错误 - 400
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        LOGGER.error("参数解析失败: ", exception);

        String fieldName = (((InvalidFormatException) exception.getRootCause()).getPath()).get(0).getFieldName(); // 字段名称
        String type = ((InvalidFormatException) exception.getRootCause()).getTargetType().getName();// 字段的类型
        Object value = ((InvalidFormatException) ((HttpMessageNotReadableException) exception).getRootCause()).getValue(); // 前端请求的值

        ValidatorResult result = new ValidatorResult(fieldName, value + " 不是 " + type + " 类型");
        return Result.build(Status.BAD_REQUEST, result);
    }

    /**
     * POST提交json数据时的异常处理 - 400
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        LOGGER.error("参数验证失败: ", exception);

      /*  // 第一种:每次单个字段验证提示
        BindingResult bindingResult = exception.getBindingResult();
        //String className = bindingResult.getObjectName();
        String field = bindingResult.getFieldError().getField();
        String message = bindingResult.getFieldError().getDefaultMessage();
        ValidatorResult result = new ValidatorResult(field, message);

        return ECPSResult.build(ECPSStatus.BAD_REQUEST_PARAMETER, result);*/

        //第二种: 一次多字段验证提示
        BindingResult bindingResult = exception.getBindingResult();

        // 获取数据校验的结果集
        List<ValidatorResult> results = ValidatorUtils.getValidatorResult(bindingResult);

        return Result.build(Status.BAD_REQUEST_PARAMETER, results);
    }


    /**
     * POST 提交 form数据时的异常处理 - 400
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(BindException.class)
    public Result handleBindException(BindException exception) {
        LOGGER.error("参数验证失败: ", exception);

        BindingResult bindingResult = exception.getBindingResult();

        Object target = bindingResult.getTarget();
        System.out.println(target);
        // 获取数据校验的结果集
        List<ValidatorResult> results = ValidatorUtils.getValidatorResult(bindingResult);

        return Result.build(Status.BAD_REQUEST_PARAMETER, results);
    }

   /* @ExceptionHandler(InvalidFormatException.class)
    public Result InvalidFormatException(InvalidFormatException exception) {
        LOGGER.error("参数格式错误: ", exception);

        return Result.build(Status.BAD_REQUEST_FORMAT);
    }*/

}
