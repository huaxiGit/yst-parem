package com.yst.controller;

import com.yst.utilts.R;
import com.yst.utilts.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanghuaxi
 * @title: testController
 * @projectName yst-parem
 * @description: TODO
 * @date 2021/1/24下午7:50
 */
@RestController
public class testController {
    @Autowired
    private RedisUtils redisUtils;
    @GetMapping("/aa")
    public R sss(){
        redisUtils.set("3ee","dffff");
        return R.ok("成功");
    }
}
