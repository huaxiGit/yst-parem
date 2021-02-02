package com.huaxi;

/**
 * @author zhanghuaxi
 * @title: demo
 * @projectName yst-parem
 * @description: TODO
 * @date 2021/1/29上午10:24
 */
public class demo {
    public static void main(String[] args) {
        //无参
         new a();
         //静态
         a.a();
        new a("dd");//有参
        a.a("d");//静态有参



    }
}
class a{
   public a(){
       System.out.println("无参");
   }
    public  static void a(){
        System.out.println("无参11");
    }

    public a(String a){
        System.out.println("有惨:"+a);
    }
    public static void a(String a){
        System.out.println("有惨:"+a);
    }
    public void ab(){
        System.out.println("ab");
    }
}

