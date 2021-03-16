package com.yst.controller;

import com.alibaba.excel.EasyExcel;
import com.yst.service.TestService;
import com.yst.utilts.R;
import com.yst.utilts.redis.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author zhanghuaxi
 * @title: testController
 * @projectName yst-parem
 * @description: TODO
 * @date 2021/1/24下午7:50
 */
@RestController
@Slf4j

public class testController {
    @Autowired
    private TestService testService;



    @Autowired
    private RedisUtils redisUtils;
    @GetMapping("/aa")
    public R sss(){
        log.info("32148942337398237483247847408422wwwwww");
        //redisUtils.set("3ee","dffff");
        return R.ok().message("成功");
    }




}
