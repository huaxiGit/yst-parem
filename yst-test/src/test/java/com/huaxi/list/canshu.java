package com.huaxi.list;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program:
 * @description:
 * @date 2021-03-12 20:35:34
 */
public class canshu {



    @Test
    public void unmodifiable1() {
      //  fff("1","2","3");
        ddf();
    }

    public void fff(String ... da){
        System.out.println(da[1]);
    }

    public void ddf(){
        B b = new B("sdff");

        //Collector<? super T, A, R> collector
    }
}
class A {
    A(String a){
        System.out.println("a:"+a);
   }
}
class B extends A{

    B(String a) {

        super(a);
    }
}