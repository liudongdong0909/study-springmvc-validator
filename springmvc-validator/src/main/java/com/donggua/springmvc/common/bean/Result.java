package com.donggua.springmvc.common.bean;

import com.donggua.springmvc.common.enums.Status;

/**
 * 统一响应结果类
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-14 下午 01:24
 */
public class Result {

    /**
     * 响应状态
     */
    private Integer status;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应数据
     */
    private Object data;

    private Result() {
    }

    private Result(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    /**
     * 响应结果 成功不返回数据
     * @return
     */
    public static Result success(){
        return new Result(Status.SUCCESS.value(), Status.SUCCESS.display(), null);
    }

    /**
     * 响应结果 成功并返回数据
     * @param data
     * @return
     */
    public static Result success(Object data){
        return new Result(Status.SUCCESS.value(), Status.SUCCESS.display(), data);
    }

    /**
     * 响应结果 失败
     * @return
     */
    public static Result error(){
        return new Result(Status.ERROR.value(), Status.ERROR.display(), null);
    }

    /**
     * 响应结果只返回状态和消息
     *
     * @param status
     * @return
     */
    public static Result build(Status status) {
        return new Result(status.value(), status.display(), null);
    }
    /**
     * 响应结果带返回状态和消息以及数据
     *
     * @param status
     * @return
     */
    public static Result build(Status status, Object data) {
        return new Result(status.value(), status.display(), data);
    }

    //响应结果并返回数据
    private static Result build(Integer status, String msg, Object data) {
        return new Result(status, msg, data);
    }
    

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
