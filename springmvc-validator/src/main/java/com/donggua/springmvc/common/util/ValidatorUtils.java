package com.donggua.springmvc.common.util;

import com.donggua.springmvc.common.bean.ValidatorResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * Hibernate Validator 数据校验工具类
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-14 下午 05:37
 */
public class ValidatorUtils {


    /**
     * 一次全部获取数据校验的结果
     *
     * @param bindingResult
     * @return
     */
    public static  List<ValidatorResult> getValidatorResult(BindingResult bindingResult) {

        List<ObjectError> allErrors = bindingResult.getAllErrors();

        List<ValidatorResult> results = new ArrayList<>();

        for (ObjectError error : allErrors) {

            //String className = error.getObjectName(); // 获取类名称
            String field = ((FieldError) error).getField(); // 获取字段名称
            String message = error.getDefaultMessage(); //获取提示信息

            results.add(new ValidatorResult(field, message));
        }
        return results;
    }
}
