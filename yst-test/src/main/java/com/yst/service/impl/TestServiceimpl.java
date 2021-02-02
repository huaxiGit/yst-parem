package com.yst.service.impl;

import com.yst.mapper.TestMapper;
import com.yst.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhanghuaxi
 * @title: TestServiceimpl
 * @projectName yst-parem
 * @description: TODO
 * @date 2021/1/27下午5:17
 */
@Service
public class TestServiceimpl implements TestService {
    @Autowired
    private TestMapper testMapper;

}
