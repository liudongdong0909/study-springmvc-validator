package com.donggua.springmvc.common.enums;

/**
 * 封装全局统一的操作消息
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-14 下午 01:26
 */
public enum Status {

    // HTTP STATUS
    // 400 - Bad Reques
    BAD_REQUEST(400, "提交参数不匹配"),

    // 400 - bad request parameter
    BAD_REQUEST_PARAMETER(400, "参数验证失败"),

    // 404 - not found
    NOT_FOUND(404, "请求结果未找到"),

    // 405 - Method Not Allowed
    METHOD_NOT_ALLOWED(405, "请求方法类型不匹配"),

    // 415 - Unsupported Media Type
    UNSUPPORTED_MEDIA_TYPE(415, "不支持当前媒体类型"),

    // 2XX成功
    SUCCESS(200, "操作成功"),
    // 5xx失败
    ERROR(500, "操作失败");

    private int value;

    private String display;

    Status() {
    }

    Status(int value, String display) {
        this.value = value;
        this.display = display;
    }

    public int value() {
        return value;
    }

    public String display() {
        return display;
    }

}
