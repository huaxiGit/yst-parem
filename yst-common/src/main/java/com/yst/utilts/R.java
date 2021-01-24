package com.yst.utilts;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhanghuaxi
 * @title: R
 * @projectName yst-parem
 * @description: TODO
 * @date 2021/1/24下午5:34
 */
@Data
@ToString
@Slf4j
public class R<T> {
    /**
     * 提示码
     */
    private Integer code;
    /**
     * 返回是否成功o
     */
    private Boolean success;
    /**
     * 提示信息
     */
    private String message;

    /**
     * 具体的内容
     */
    private T data;
    public R(){}

    public R(CodeEnum code, T data) {
        this.code=code.getCode();
        this.message=code.getMsg();
        this.success=true;
        this.data = data;
    }
    public static<T> R ok(T data) {
        R r=new R();
        r.setSuccess(true);
        r.setCode(CodeEnum.SUCCESS.getCode());
        r.setMessage(CodeEnum.SUCCESS.getMsg());
        r.setData(data);
        return r;
    }
    //失败静态方法
    public static R error() {
        R r = new R();
        r.setSuccess(false);
        r.setCode(CodeEnum.ERROR.getCode());
        r.setMessage(CodeEnum.ERROR.getMsg());
        return r;
    }

    /**
     * 根据 code， 和  msg, 和 data 构建返回结果
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> R<T> build(Boolean success,Integer code, String msg, T data) {
        R r = new R();
        r.setSuccess(success);
        r.setCode(code);
        r.setMessage(msg);
        r.setData(data);
        return r;
    }

    /**
     *  根据封装CodeEnum 响应码构建放回结果集
     * @param data
     * @param codeEnum
     * @param success
     * @param <T>
     * @return
     */
    public static <T> R<T> build( T data,CodeEnum codeEnum,Boolean success) {
        R r = new R();
        r.setSuccess(success);
        r.setCode(codeEnum.getCode());
        r.setMessage(codeEnum.getMsg());
        r.setData(data);
        return r;
    }

    public  R message(String message){
        this.setMessage(message);
        return this;
    }



    public static <T> R<T> SUCCESS(CodeEnum code, T data) {
        return new R<T>(code, data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }



}
