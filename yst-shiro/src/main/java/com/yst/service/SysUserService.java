package com.yst.service;

import com.yst.pojo.UUser;

/**
 * @author zhanghuaxi
 * @title: SysUserService
 * @projectName yst-parem
 * @description: TODO
 * @date 2021/1/26下午8:33
 */
public interface SysUserService {
    UUser getUserByUserNameWithPermission(String username);
}
