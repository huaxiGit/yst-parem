package com.yst.utilts;

/**
 * @author zhanghuaxi
 * @title: CodeEnum
 * @projectName yst-parem
 * @description: 封装状态码使用枚举
 * @date 2021/1/24下午5:42
 */
public enum CodeEnum {
    SUCCESS(200, "成功！"),
    ERROR(201, "失败，未知错误！"),;

    /**
     * 响应状态码
     */
    private  Integer code;

    /**
     * 响应提示
     */
    private  String msg;

    CodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
