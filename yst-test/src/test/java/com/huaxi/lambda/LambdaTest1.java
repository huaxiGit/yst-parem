package com.huaxi.lambda;

import com.google.common.collect.Maps;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program: 学习Stream Api
 * @description: 学习Stream Api
 * @date 2021-02-17 12:43:12
 */
public class LambdaTest1 {



    /**
     * filter 条件
     */
    @Test
    public void test1(){
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(4);
        numbers.add(8);
        numbers.add(16);
        numbers.add(19);
        numbers.add(27);
        numbers.add(23);
        numbers.add(99);
        numbers.add(15);
        numbers.add(32);
        numbers.add(5);
        numbers.add(232);
        numbers.add(56);

        List<Users> list= Arrays.asList(
                new Users(2L,"q",55),
                new Users(2L,"w",56),
                new Users(2L,"e",57),
                new Users(4L,"r",58),
                new Users(2L,"t",59)
        );


        System.out.println("================filter 排序判断====================");
        numbers.stream().filter(o->o>20).forEach(System.out::println);
        System.out.println("=================sorted 排序=========================");
        numbers.stream().sorted().forEach(System.out::println);
        System.out.println("=================排序=========================");
        numbers.stream().filter(b->b==3).sorted().forEach(System.out::println);
        System.out.println("=================对象排序=========================");
        list.stream().filter(o->o.getAge()==55)
                .sorted((x,y) -> x.getId().intValue()-y.getId().intValue())
                .forEach(System.out::println);
        System.out.println("==================总数========================");
        Integer[] array = new Integer[]{3,4,8,16,19,27,23,99,76,232,33,96};
        long count = Arrays.stream(array).filter(i->i>20).count();
        System.out.println(count);

        long sum = Stream.of(12,77,59,3,654).filter(i->i>20).mapToInt(Integer::intValue).sum();
        System.out.println("count："+count+",sum:"+sum);



    }

    /**
     * map map方法指对一个流中的值进行某种形式的转换。需要传递给它一个转换的函数作为参数。
     */
    @Test
    public  void test3(){
        List<Integer> integerList = Lists.newArrayList();
        integerList.add(15);
        integerList.add(32);
        integerList.add(5);
        integerList.add(232);
        integerList.add(56);
        //将Integer类型转换成String类型
       integerList.stream().map(i->String.valueOf(i)).collect(Collectors.toList()).forEach(System.out::println);

       integerList.stream().map(o->String.valueOf(o)).collect(Collectors.toList()).forEach(System.out::println);


    }

    /**
     * flatMap
     *上面用map方法进行流转换的时候，是对每个元素应用一个函数，并将返回的值收集到一个新的流中。但是如果有一个函数，它返回的不是一个值，而是一个包含多个值的流。但是你需要的是一个包含多个流中的元素的集合。
     *   意思是两个流放到一个流中::这个时候就应该使用flatMap将多个流进行合并，然后再收集到一个集合中。
     */
    @Test
    public void test4(){
        List<Integer> oneList = Lists.newArrayList(),
                twoList = Lists.newArrayList();
        oneList.add(34);
        oneList.add(23);
        oneList.add(87);

        twoList.add(29);
        twoList.add(48);
        twoList.add(92);
        Map<String,List<Integer>> testMap = Maps.newHashMap();
        testMap.put("1",oneList);
        testMap.put("2",twoList);
        //返回的是一个流的集合，但是我需要的是List<Integer>这样一个集合
       // List<Stream<Integer>> testList = testMap.values().stream().map(number->number.stream()).collect(Collectors.toList());

       // 这个时候就应该使用flatMap将多个流进行合并，然后再收集到一个集合中。
        testMap.values().stream().flatMap(number->number.stream()).collect(Collectors.toList()).forEach(System.out::println);
        //这方式是把另一个list存入到oneList集合中,存在内存存入
        oneList.addAll(twoList);
        oneList.forEach(System.out::println);


    }

    /**
     * limit方法和skip方法  分页功能
     */

    @Test
    public void test8(){
        List<Integer> myList = Lists.newArrayList();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        List<Integer> afterLimit = myList.stream().limit(4).collect(Collectors.toList());
        System.out.println("afterLimit:"+afterLimit);

        //skip(n)方法正好相反，它会丢弃掉前面的n个元素。
        List<Integer> afterSkip = myList.stream().skip(4).collect(Collectors.toList());
        System.out.println("afterSkip："+afterSkip);


        //用limit和skip方法一起使用就可以实现日常的分页功能：
/*        List<Integer> pageList = myList.stream()
                        .skip(pageNumber*pageSize)
                        .limit(pageSize).collect(Collectors.toList());*/

    }

    /**
     * distinct方法和sorted方法
     *  distinct方法会根据原始流中的元素返回一个具有相同顺序、去除了重复元素的流，这个操作显然是需要记住之前读取的元素。   去重排序
     *  sorted方法是需要遍历整个流的，并在产生任何元素之前对它进行排序。因为有可能排序后集合的第一个元素会在未排序集合的最后一位。 直接排序
     */
    @Test
    public void test9(){
        List<Integer> myTestList = Lists.newArrayList();
        myTestList.add(10);
        myTestList.add(39);
        myTestList.add(10);
        myTestList.add(78);
        myTestList.add(10);
        //去重排序
        List<Integer> distinctList = myTestList.stream()
                                    .distinct().collect(Collectors.toList());
        System.out.println("distinctList："+distinctList);
        //直接排序
        myTestList.stream().sorted().collect(Collectors.toList()).forEach(e-> System.out.println(e));
    }

    /**
     * 聚合操作
     */


    /**
     * max方法和min方法
     * 在前面的代码例子中使用的count方法和sum方法都属于流从聚合方法。还有两个聚合方法是max方法和min方法，分别返回流中最大值和最小值。
     */
    @Test
    public void test11(){
        List<Integer> hearList = Lists.newArrayList();
        hearList.add(15);
        hearList.add(32);
        hearList.add(5);
        hearList.add(232);
        hearList.add(56);
        hearList.add(29);
        hearList.add(94);
        Integer maxItem = hearList.stream().max(Integer::compareTo).get();
        Integer minItem = hearList.stream().min(Integer::compareTo).get();
        System.out.println("max:"+maxItem+"，min:"+minItem);

    }

    /**
     * findFirst方法返回非空集合中的第一个值，它通常与filter方法结合起来使用。
     * findAny方法可以在集合中只要找到任何一个所匹配的元素，就返回，此方法在对流并行执行时十分有效（任何片段中发现第一个匹配元素都会结束计算，串行流中和findFirst返回一样)。
     * anyMatch方法可以判定集合中是否还有匹配的元素。返回结果是一个boolean类型值。
     * allMatch方法和noneMatch方法，分别在所有元素匹配和没有元素匹配时返回true。
     */
    @Test
    public void test12(){
        List<Integer> hearList = Lists.newArrayList();
        hearList.add(15);
        hearList.add(32);
        hearList.add(5);
        hearList.add(232);
        hearList.add(56);
        hearList.add(29);
        hearList.add(104);
        Integer first = hearList.stream().filter(i->i>100).findFirst().get();
        System.out.println(first);
        Integer anyItem = hearList.stream().filter(i->i>100).findAny().get();
        System.out.println(anyItem);
        boolean allHas = hearList.parallelStream().allMatch(i->i>100);
        boolean noHas = hearList.parallelStream().noneMatch(i->i>100);
    }
    /**
     * reduce方法是将流中的元素进行进一步计算的方法。
     */
    @Test
    public void test14(){
        List<Integer> hearList = Lists.newArrayList();
        hearList.add(15);
        hearList.add(32);
        hearList.add(5);
        hearList.add(232);
        hearList.add(56);
        hearList.add(29);
        hearList.add(104);
//求和
        Integer sum = hearList.stream().reduce((x,y)->x+y).get();
        System.out.println("sum:"+sum);
//简化一下，求和
        sum = hearList.stream().reduce(Integer::sum).get();
        System.out.println("sum:"+sum);
//含有初始标识的，求和
        sum = hearList.stream().reduce(0,(x,y)->x+y);
        System.out.println("sum:"+sum);
//对元素的长度进行求和( (total,y)->total+y.toString().length()，类似于一个累加器，会被重复调用)
        sum = hearList.stream().reduce(0,(total,y)->total+y.toString().length(),(total1,total2)->total1+total2);
        System.out.println("sum:"+sum);
//简化一下，对元素长度进行求和。
        sum = hearList.stream().map(Objects::toString).mapToInt(String::length).sum();
        System.out.println("sum:"+sum);
    }

    /**
     * 收集结果
     * Collectorts类为我们提供了常用的收集类的各个工厂方法。
     */

    @Test
    public void test15(){
        List<Integer> hereList=Lists.list();
        List<Integer> thereList = hereList.stream().collect(Collectors.toList());

    }

    /**
     * 拼接
     * 将字流中的字符串连接并收集起来。 joining
     */
    @Test
    public void test16(){
        List<String> stringList=Lists.list();
        stringList.add("22233");
        stringList.add("22233");
        stringList.add("22233");
        stringList.add("22233");
        //拼接字符串  结果:22233222332223322233
        String resultString = stringList.stream().collect(Collectors.joining());
        System.out.println(resultString);
        //遍历字符串
        stringList.stream().forEach(System.out::println);
        System.out.println("--------------------------经常用的字符串拼接-------------------------------------------------");
        String resultString1 = stringList.stream().collect(Collectors.joining(","));
        //结果:22233,22233,22233,22233
        System.out.println(resultString1);
        //不是字符串时候,把转换字符串再拼接
        String hereResultString = stringList.stream()
                        .map(String::valueOf).collect(Collectors.joining(","));



    }

    /**
     *
     * 收集聚合
     */
    @Test
    public void test17(){
        List<Integer> hereList = Lists.newArrayList();
        hereList.add(15);
        hereList.add(32);
        hereList.add(5);
        hereList.add(232);
        hereList.add(56);
        hereList.add(29);
        hereList.add(104);

//总和、平均值，最大值，最小值
        int sum = hereList.stream().collect(Collectors.summingInt(Integer::intValue));
        Double ave = hereList.stream().collect(Collectors.averagingInt(Integer::intValue));
        Integer max = hereList.stream().collect(Collectors.maxBy(Integer::compare)).get();
        Integer min = hereList.stream().collect(Collectors.minBy(Integer::compare)).get();
        System.out.println("sum:"+sum+",ave:"+ave+",max:"+max+",min:"+min);

        //一次性收集流中的结果，聚合为一个总和，平均值，最大值或最小值的对象。
        IntSummaryStatistics summaryStatistics = hereList.stream()
                                            .collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println(summaryStatistics);
    }


    /**
     * 将结果集收集到Map
     *
     *  当我们希望将集合中的元素收集到Map中时，可以使用Collectors.toMap方法。这个方法有两个参数，用来生成Map的key和value。
     *  注意：每个toMap方法，都会有一个对应的toConCurrentMap方法，用来生成一个并发Map
     */
    @Test
    public void test18(){
        List<Room> roomList=Lists.newArrayList(
                new Room(1,23,45),
                new Room(2,27,47),
                new Room(3,29,46)
        );
        //当我们希望将集合中的元素收集到Map中时，可以使用Collectors.toMap方法。这个方法有两个参数，用来生成Map的key和value。

        //例如将一个Room对象的high作为键width作为值
        //结果: key[1, 2, 3]values[23, 27, 29]
        Map<Integer,Integer> hwMap = roomList.stream()
                                        .collect(Collectors.toMap(Room::getHigh, Room::getWidth));
        System.out.println("key"+hwMap.keySet()+"values"+ hwMap.values());
       //但是通常还是以具体元素作为值的情况多，可以使用Function.identity()来获取实际元素。
        Map<Integer,Room> roomMap = roomList.stream()
                                        .collect(Collectors.toMap(Room::getHigh, Function.identity()));
        System.out.println("key"+roomMap.keySet()+"values"+ roomMap.values());
        //如果多个元素拥有相同的键，在收集结果时会抛出java.lang.IllegalStateException异常。可以使用第三个参数来解决，第三个参数用来确定当出现键冲突时，
        // 该如何处理结果，如果当出现键冲突时只保留一个并且是保留已经存在的值时，就是如下方式。
        Map<Integer,Room> rMap = roomList.stream()
                .collect(Collectors.toMap(Room::getHigh, Function.identity(),(nowValue,newValue)->nowValue));

    }


    /**
     * 分组分片  https://www.cnblogs.com/jimoer/p/10995574.html
     */


}
