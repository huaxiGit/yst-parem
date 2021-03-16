package com.huaxi.customzhujie;

import org.junit.Test;

import java.lang.annotation.*;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program: 学习自定义注解
 * @description: 学习自定义注解
 * @date 2021-03-06 18:18:43
 */

/**
 *  总共有4个注解使用
 * @Document
 * @Target
 * @Retention
 * @Inherited
 */

/**
 *  /** 类，接口（包括注解类型）或枚举的声明 */
    /*TYPE,
         *
         *     /** 属性的声明
         *FIELD,
         *
         *     /** 方法的声明
         *METHOD,

         *     /** 方法形式参数声明
         *PARAMETER,
         *
         *     /** 构造方法的声明
         *CONSTRUCTOR,
         *
         *     /** 局部变量声明
         *LOCAL_VARIABLE,
         *
         *     /** 注解类型声明
         *ANNOTATION_TYPE,
         *
         *     /** 包的声明
         *PACKAGE

 */


    /*
    /**
                 * Annotations are to be discarded by the compiler.
                 * （注解将被编译器忽略掉）


                 SOURCE,


             * Annotations are to be recorded in the class file by the compiler
             * but need not be retained by the VM at run time.  This is the default
             * behavior.
             * （注解将被编译器记录在class文件中，但在运行时不会被虚拟机保留，这是一个默认的行为）

            CLASS,

            /**
             * Annotations are to be recorded in the class file by the compiler and
             * retained by the VM at run time, so they may be read reflectively.
             * （注解将被编译器记录在class文件中，而且在运行时会被虚拟机保留，因此它们能通过反射被读取到）
             * @see java.lang.reflect.AnnotatedElement

            RUNTIME
           */



@Target(value = {ElementType.TYPE,ElementType.METHOD})  //在哪里时候 类, 方法上,等
@Retention(RetentionPolicy.CLASS) //运行时候, 那个环境下有效
@Documented()
public @interface zhujieDemo {     // @interface  关键字 在底层实现上，所有定义的注解都会自动继承java.lang.annotation.Annotation接口。
    String name();
    int age() default 18;      //  default代表默认值
    int[] array();
}


 class Student {

    @zhujieDemo(name = "cherry-peng",age = 23,array = {99,66,77})
    public void study(int times){
        for(int i = 0; i < times; i++){
            System.out.println("Good Good Study, Day Day Up!");
        }
    }
}


