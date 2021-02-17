package com.huaxi.lambda;

import com.google.common.collect.Lists;

import org.apache.tomcat.jni.Status;
import org.junit.Test;
import org.junit.platform.engine.TestExecutionResult;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program:
 * @description:    学习网址:: https://www.jianshu.com/p/8e3b8a483bd8
 *                              https://www.cnblogs.com/jimoer/p/10995574.html
 * @date 2021-02-16 16:30:16
 */
public class lambdaTest {

    @Test
    public void test(){
        Runnable r=()->{};
        Comparable c=(o)->{
            {
                System.out.println("333");
            }
            return 0;
        };

        List<String> list=new ArrayList<>();




    }
    @Test
    public void test1(){
        List<String> list = Lists.newArrayList();
        List<String> list1 = new ArrayList<>();
        list.add("2");
        list.forEach(eee-> System.out.println(eee));
        Collectors.toList();


    }
    @Test
    public void tes2(){
        List<Integer> list= Arrays.asList(2,3,4,5,33,21,2,3);
        list.stream()
                .limit(4)
                .forEach(o-> System.out.println(o));
    }


    @Test
    public void test3(){
        List<Users> userList = Lists.newArrayList();//存放user对象集合

        Users user1 = new Users(1L, "张三", 24);
        Users user2 = new Users(2L, "李四", 27);
        Users user3 = new Users(3L, "王五", 21);
        Users user4 = new Users(4L, "张三", 22);
        Users user5 = new Users(5L, "李四", 20);
        Users user6 = new Users(6L, "王五", 28);

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        //==========================map==========================
      // userList.stream().map(o->o.getName()).forEach(System.out::println);
        // userList.stream().map(o -> o.getName()).forEach(ee-> System.out.println(ee));
        userList.stream().map(Users::getName).forEach(System.out::println);

        //=================引进flatMap============================
        //map跟flatMap还是有区别的，map是一个个流（这个流中有元素）加入流中，flatMap是将一个个流中的元素加入流中。
        //Stream<Character> flatMap =  userList.stream().flatMap(lambdaTest::filterCharacter );


    }
    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character character : str.toCharArray()) {
            list.add(character);
        }
        return list.stream();
    }
    @Test
    public void test5(){
        List<String> list=Arrays.asList("ccc","aaa","bbb","ddd","eee");
        list.stream()
                .sorted()
                .forEach(o-> System.out.println(o));
    }
    @Test
    public void test6(){
        List<Users> list= Arrays.asList(
                new Users(3L,"e",34),
                new Users(3L,"er",35),
                new Users(3L,"ert",36)
        );
        list.stream().forEach(System.out::println);
    }
    @Test
    public void test7(){
        List<Users> list= Arrays.asList(
                new Users(3L,"e",34),
                new Users(3L,"er",35),
                new Users(3L,"ert",36)
        );
      /*  boolean b = list.stream().allMatch((e) -> e.getAge().equals(Status.APR_ANONYMOUS));
        System.out.println(b);*/
        Optional<Users> first = list.stream().sorted(Comparator.comparingInt(Users::getAge)).findFirst();
        System.out.println(first);

    }
    @Test
    public void Test8(){
        List<Users> emps=Arrays.asList(
                new Users(2L,"eerr",56),
                new Users(2L,"eerr",56),
                new Users(2L,"eerr",56),
                new Users(2L,"eerr",56)
        );

        List<String> collect = emps.stream()
                .map(Users::getName)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

}
