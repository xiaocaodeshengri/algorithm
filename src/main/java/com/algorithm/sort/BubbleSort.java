package com.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {


    /**
     * 冒泡排序：
     *    就是左右比较大得泡泡跑到右边
     *    你看时间复杂度是多少？ O（N^2）
     *    如果像1，2，3，4，5，6样得数组就比较一次，如何实现呢？
     *    在里面添加一个flag是时间复杂度变成O（n）
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {1, 3, 6, 2, 9, 4, 8,7};
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {  //循环了几次
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j++) { //循环了几次就确定了几个最大得数因此需要减i
                if (a[j] > a[j + 1]) {
                   /* int temp = a[j];
                    a[j] = a[j + 1];
                    a[j+1]=temp;*/
                    a[j] = a[j]+a[j+1];
                    a[j+1] = a[j]-a[j+1];
                    a[j]=a[j]-a[j+1];
                    /**
                     * a[j] = a[j]+a[j+1]
                     * a[j+1] = a[j]-a[j+1]
                     * a[j]=a[j]-a[j+1]
                     */

                    flag=true;
                }
            }
          //如果一次也没有交换
          if (!flag) break;
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 不使用temp来进行a 和b得交换
     *   a:2，b：3
     *   结果：a:3 b:2
     *
     *   a=a+b------> a=2+3 =5
     *   b=a-b------> b=a-b=5-3=2
     *   a=a-b------> a=a-b = 5-2=3
     *
     *
     *
     *
     */
}
