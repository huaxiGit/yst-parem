package com.yst.utilts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //生成有参构造方法
@NoArgsConstructor  //生成无参构造方法
public class GuliException extends RuntimeException {
    private Integer code;//状态码
    private String msg;  //异常处理
    private Exception e;
    //有参的构造方法
    public GuliException(String message){
        super(message);

    }

    // 用指定的详细信息和原因构造一个新的异常
    public GuliException(String message, Throwable cause, Exception e){

        super(message,cause);
        this.e=e;
    }

    //用指定原因构造一个新的异常
    public GuliException(Throwable cause) {

        super(cause);
    }
}
