package com.yst.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author zhanghuaxi
 * @title: UUser
 * @projectName yst-parem
 * @description: TODO
 * @date 2021/1/27下午5:03
 */
@Data
public class UUser {
    private String user;
    private String password;
    private List<String> power;
}
