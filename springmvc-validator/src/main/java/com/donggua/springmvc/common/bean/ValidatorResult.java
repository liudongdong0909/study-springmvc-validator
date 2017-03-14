package com.donggua.springmvc.common.bean;

/**
 * 参数校验信息封装类
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-14 下午 01:36
 */
public class ValidatorResult {

    /**
     * 类名
     */
    // private String className;

    /**
     * 字段名
     */
    private String filed;

    /**
     * 参数校验提示信息
     */
    private String message;

    public ValidatorResult() {
    }

    public ValidatorResult(String filed, String message) {
        this.filed = filed;
        this.message = message;
    }

    /*public ValidatorResult(String className, String filed, String message) {
        this.className = className;
        this.filed = filed;
        this.message = message;
    }*/
/*
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }*/

    public String getFiled() {
        return filed;
    }

    public void setFiled(String filed) {
        this.filed = filed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ValidatorResult{" +
                "filed='" + filed + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
