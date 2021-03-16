package com.huaxi.lambda;

import com.google.common.collect.Lists;

import com.google.common.collect.Maps;
import org.apache.tomcat.jni.Status;
import org.junit.Before;
import org.junit.Test;
import org.junit.platform.engine.TestExecutionResult;

import java.lang.reflect.Array;
import java.text.MessageFormat;
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

    /**
     *
     * @BeforeClass：针对所有测试，只执行一次，且必须为static void
     * @Before：初始化方法，执行当前测试类的每个测试方法前执行。
     * @Test：测试方法，在这里可以测试期望异常和超时时间
     * @After：释放资源，执行当前测试类的每个测试方法后执行
     * @AfterClass：针对所有测试，只执行一次，且必须为static void
     * @Ignore：忽略的测试方法（只在测试类的时候生效，单独执行该测试方法无效）
     * @RunWith:可以更改测试运行器 ，缺省值 org.junit.runner.Runner

     */



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
    @Test
    public void dsdd(){
        String aa="1233$s3333%s33";
        String format = String.format(aa,"ee","ww");
        System.out.println(format);
    }

    @Test
    public void sdf(){


    }

    /**
     *  两个for
     */
    @Test
    public void sdff(){
        HashMap<String, String> map = Maps.newHashMap(),
                map2 = Maps.newHashMap();
        map.put("1", "张三");
        map.put("2", "李四");
        map.put("3", "王五");
        map2.put("4", "德玛西亚");
        map2.put("5", "索瑞玛");
        map2.put("6", "艾欧尼亚");
        ArrayList<Map<String,String>> list= org.assertj.core.util.Lists.newArrayList();
        list.add(map);
        list.add(map2);
            list.stream().forEach(
                    ma->{
                        ma.forEach((k,v)-> System.out.println(v));
                    }
            );
         list.forEach(map1 -> map1.forEach((k,v)-> System.out.println(k+"----"+v)));


    }

    HashMap<String, String> map = Maps.newHashMap(),
            map2 = Maps.newHashMap();
    List<String> list=Lists.newArrayList(),
                list2=Lists.newArrayList(),
                list3=Lists.newArrayList();
    @Before
    public void kais(){
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("7");
        list2.add("2");
        list2.add("8");
        list2.add("9");
        list2.add("10");
        list3.add("9");
        list3.add("10");

        map.put("1", "张三");
        map.put("2", "李四");
        map.put("3", "王五");
        map2.put("4", "德玛西亚");
        map2.put("5", "索瑞玛");
        map2.put("6", "艾欧尼亚");
    }
    @Test
    public void sdffss(){
        for (int i=0;i<list.size();i++){
            for (int j=0;j<list2.size();j++){
                if (Objects.equals(list.get(i),list2.get(j))){
                    System.out.println(list2.get(j));
                    break;
                }
            }
        }
    }
    @Test
    public void sdffs(){
        map.forEach((k,v)->{
            System.out.println(k+"------------"+v);
        });
        list.stream().forEach(
                list->{
                    list2.stream().filter(list2->Objects.equals(list,list2))
                            .forEach(r->{
                                if(r.isEmpty()){
                                    System.out.println(r);
                                    return;
                                }
                                    }

                                    );
                    System.out.println(list);
                }
        );
    }
    @Test
    public void sdffsss(){

    }



}
