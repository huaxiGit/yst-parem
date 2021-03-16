package com.huaxi.lambda;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program:
 * @description:
 * @date 2021-03-06 21:08:00
 */
public class lamdbaTest2 {
    @Test
    public void lambdaFor(){
        List<Room>  list= Lists.newArrayList(
                new Room(12,34,56),
                new Room(13,35,57),
                new Room(14,36,58),
                new Room(15,37,59)
        );

        List<Room> list1=Lists.newArrayList(
                new Room(12,34,56),
                new Room(13,35,57)
        ),
                list2=Lists.newArrayList(
                        new Room(14,36,58),
                        new Room(15,37,59)
                );

        list.stream().filter(r-> Objects.equals(r,30) || r.getLength()!=12)
                .map(Room::getHigh).forEach(
                        i-> {
                            if (13<i){
                                System.out.println(i);;
                            }
                        }
        );

        list.stream().filter(r->{
            if (true){
                System.out.println("好的");
                return true;
            }
            return false;
        }).map(Room::getHigh);

        // tomap 没有练习


    }





    @Test
    public void tomap(){
        List<Room>  list= Lists.newArrayList(
                new Room(12,34,56),
                new Room(13,35,57),
                new Room(14,36,58),
                new Room(15,37,59)
        );

        List<Room> list1=Lists.newArrayList(
                new Room(12,34,56),
                new Room(13,35,57)
        ),
                list2=Lists.newArrayList(
                        new Room(14,36,58),
                        new Room(15,37,59)
                );

        Map<Integer, Integer> collect = list.stream().collect(Collectors.toMap(Room::getLength, room -> room.getHigh()));
        collect.forEach((k,v)->{
            System.out.println("k:"+k+"v:"+v);
        });
        /*tomap*/
        list.stream().collect(Collectors.toMap(room -> room.getHigh(),Room::toString)).forEach((k,v)->{
            System.out.println("k:"+k+"v:"+v);
        });





    }




















































}
