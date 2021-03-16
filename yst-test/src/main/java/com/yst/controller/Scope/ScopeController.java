package com.yst.controller.Scope;


import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program:
 * @description:    多实例模式
 * @date 2021-03-06 20:31:08
 */
//@Scope(value = "prototype")
@RestController
public class ScopeController {

    private int index =0;
    private static  int staticIndex =0;

    /**
     * 多例模式   ::  >>  对于多例情况普通属性时不会共用的，不会产生影响，对于静态属性会去共用这个属性。      多例提供内存区
     * @return
     */
    @GetMapping("/acope")
    public  String acope(){
       /* List<Integer> list=new ArrayList<>();*/

        System.out.println("普通:"+(index++) + "静态:"+(staticIndex++));
        /*
        *   普通:0静态:0
            普通:1静态:1
            普通:2静态:2
            普通:3静态:3
        * */
        return "cheng";
    }

    /**
     *  单例模式    ::   ->>   对于单例情况普通属性和静态属性都会被共用
     * @return
     */


    @Scope(value = "prototype")
    @GetMapping("/acope1")
    public String acope1(){
        /* List<Integer> list=new ArrayList<>();*/
        System.out.println("普通:"+(index++) + "静态:"+(staticIndex++));
        /*

        *   普通:0静态:0
            普通:1静态:1
            普通:2静态:2
        * */
        return "cheng";
    }

    //静态方法是在类中使用staitc修饰的方法，在类定义的时候已经被装载和分配。
    // 而非静态方法是不加static关键字的方法，在类定义时没有占用内存，只有在类被实例化成对象时，对象调用该方法才被分配内存。

    @GetMapping("/acope3")
    public String acope2(){
        int a=0;
        /* List<Integer> list=new ArrayList<>();*/
        System.out.println("普通:"+(index++) + "静态:"+(staticIndex++)+"方法内普通:"+(a++));
        aa(a);
        /*

        *   普通:0静态:0
            普通:1静态:1
            普通:2静态:2
        * */
        return "cheng";
    }
    public void aa(int a){
        System.out.println("方法内:"+a);
    }



}
