package com.huaxi.list;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program:
 * @description:
 * @date 2021-02-04 17:08:48
 */
public class LinkedListTest {
    @Test
    public void test(){
        List list=new LinkedList();
        List its=new ArrayList();
        for (int i=0;i<100;i++){
            list.add(i);
            its.add(i);
        }
        System.out.println("```````````````");
        Iterator it=list.listIterator(4);
        while (it.hasNext()){
            it.next();
          //  System.out.println(it.next().toString());
        }

        Iterator Ait=list.iterator();
       while ( Ait.hasNext()){
           System.out.println(" Ait.hasNext():"+ Ait.hasNext());
           Student a=new Student();
           a.setAge((Integer) Ait.next());
           System.out.println( Ait.next());
       }

       /* long timeMillis = System.currentTimeMillis();
        System.out.println("迭代："+timeMillis);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        long timeMillis1 = System.currentTimeMillis();
        System.out.println("for："+timeMillis1);
*/

    }

}
