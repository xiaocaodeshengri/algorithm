package com.algorithm.array;

import com.sun.org.apache.regexp.internal.RE;

import java.io.*;
import java.util.Random;

/**
 * 计算14亿人口的年龄的分配
 */
public class AgeTest {

    public static void main(String[] args) throws Exception {
        //先生成14亿人口的文件
      String fileName = "D:\\123.txt";
        Random random = new Random();
        BufferedWriter write = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i <1400000000 ; i++) {
           int a= random.nextInt(130);
            write.write(a+"\r\n");
        }
        write.flush();
        write.close();

        System.out.println("写入完成");
        //速度计算
        int[] a = new int[130];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String str =null;
        int total =0;
        while((str =reader.readLine()) !=null){
           int  age = Integer.valueOf(str);
           a[age]++;
           total++;
        }
        System.out.println("一共有"+total);
        for (int i =0;i<130;i++){
            System.out.println("年龄"+i+"----->"+a[i]);
        }
    }

}
