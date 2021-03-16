package com.yst.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program:
 * @description:
 * @date 2021-03-06 11:40:28
 */
@RestController
@Slf4j
@RequestMapping("/aop")
public class AopController {


    @RequestMapping(value = "/operation", method = RequestMethod.GET)
    public Object operation(@RequestParam("key") String key) {
        return key;
    }



}