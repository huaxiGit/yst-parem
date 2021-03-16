package com.huaxi.lambda;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

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
    private Set<String> trackNames = new HashSet<>();
    public Users(long l, String name, int i) {
        this.id=l;
        this.name=name;
        this.age=i;

    }
}
