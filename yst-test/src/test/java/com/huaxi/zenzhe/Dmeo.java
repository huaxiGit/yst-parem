package com.huaxi.zenzhe;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhanghuaxi
 * @author Administrator
 * @program:
 * @description:
 * @date 2021-03-03 15:42:29
 */
public class Dmeo {
    @Test
    public void sss(){
        //0:开*w关,1:关*开e关
        String aa="0:开*e关,1:关*w关";
        String substring = aa.substring(0, aa.lastIndexOf(","));
        System.out.println(substring);  //0:开*开关
        String substring1 = substring.substring(0, substring.lastIndexOf(":"));
        System.out.println(substring1);  //0
        String substring2 = substring.substring( substring.lastIndexOf(":")+1,substring.lastIndexOf("*"));
        System.out.println("substring2"+substring2);  //开
        String substring3 = substring.substring(substring.lastIndexOf("*")+1);
        System.out.println(substring3);  //开关

        String substring4 = aa.substring(aa.lastIndexOf(",")+1);
        System.out.println(substring4);  //1:关*w关


    }

    @Test
    public void sdff(){
       // 20-30:状态*状态描述,20-30:状态*状态描述,20-30:状态*状态描述
        String aa="20-30:状态*状态描述1,20-30:状态*状态描述2,20-30:状态*状态描述3";
        String[] split = aa.split(",");   //20-30:状态*状态描述1
        System.out.println(split[0]);//20-30:状态*状态描述1
        String substring = split[0].substring(0, split[0].lastIndexOf(":"));
        System.out.println(substring);  //20-30
        String substring1 = split[0].substring(split[0].lastIndexOf(":")+1);
        System.out.println(substring1);  //状态*状态描述1

        String substring2 = substring1.substring( substring1.lastIndexOf("*")+1);  //状态描述1
        System.out.println(substring2);  //状态





       /* String substring = aa.substring(aa.lastIndexOf(",")+1,aa.lastIndexOf(","));
        System.out.println(substring);*/



    }

    @Test
    public void dsdsd(){
        String aa="20-30:状态*状态描述,20-30:状态*状态描述,20-30:状态*状态描述";
        String[] split = aa.split(",");  //3
        for (int i=0;i<split.length;i++){

            String variableSection = split[i].substring(i, split[i].lastIndexOf(":"));// 20-30
            String substring1 = split[i].substring(split[i].lastIndexOf(":")+1); //状态*状态描述1
            String Status = substring1.substring(substring1.lastIndexOf("*"));//状态
            String variableDes = substring1.substring(substring1.lastIndexOf("*") + 1);//状态描述1
            System.out.println(variableDes);

        }
    }
    @Test
    public void ssdsf(){
        String aa="0:开*e关,1:关*w关";
        Pattern StART_RANGE = Pattern.compile( "^[1-9]:?[\u4e00-\u9fa5]+?[\u4e00-\u9fa5]+$");
    // Matcher matcher=StART_RANGE.matcher(addrHigh);
         //   boolean b = matcher.find();

    }
}
