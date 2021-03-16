package com.huaxi.customzhujie;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program:
 * @description:
 * @date 2021-03-06 18:37:34
 */
public class Demo1 {

    public void doSomething() { }
    @MyTarget(name = "sddddd")
    private String name;

    @Resource
    public static void main(String[] args) throws Exception{
    /*    Method method = Demo1.class.getMethod("doSomething",null);
        if(method.isAnnotationPresent(MyTarget.class))
        {                              System.out.println(method.getAnnotation(MyTarget.class));
        }*/
        sdsf(Demo1.class);


    }

    public static void sdsf(Class<?> clasz){
        Field[] fields = clasz.getDeclaredFields();
        for(Field field :fields){
            if(field.isAnnotationPresent(MyTarget.class)) {
                MyTarget name = (MyTarget) field.getAnnotation(MyTarget.class);
                String carColour = "汽车的中文名：" + name.name();
                System.out.println(carColour);   //打印出来的  ->>　　　汽车的中文名：sddddd
            }
        }
    }




}
