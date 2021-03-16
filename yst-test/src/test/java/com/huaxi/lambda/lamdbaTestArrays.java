package com.huaxi.lambda;


import org.assertj.core.util.Strings;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program:
 * @description:
 * @date 2021-02-20 15:09:18
 */
public class lamdbaTestArrays {
    @Test
    public void Arrays(){
        String[] str=new String[100];
        Arrays.asList(str).forEach(System.out::println);
        String string = Arrays.toString(str);


    }
    //这个方法可能报错（java.lang.IllegalStateException: Duplicate key），因为name是有可能重复的。toMap有个重载方法，可以传入一个合并的函数来解决key冲突问题：

    public Map<String, Users> getNameAccountMap(List<Users> accounts) {

       // return accounts.stream().collect(Collectors.toMap(accounts::get, Function.identity(), (key1, key2) -> key2));
        return null;
    }

    @Test
    public void sdfsd(){
        String aa="333";
        Integer bb=23;

    }

}
