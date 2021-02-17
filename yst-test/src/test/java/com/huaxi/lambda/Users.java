package com.huaxi.lambda;

import lombok.Data;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program:
 * @description:
 * @date 2021-02-16 17:19:00
 */
@Data
public class Users {
    private Long id;
    private String name;
    private Integer age;

    public Users(long l, String name, int i) {
        this.id=l;
        this.name=name;
        this.age=i;

    }
}
