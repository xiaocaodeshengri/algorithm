package com.algorithm.sort;

public class ShellSort {

    /**
     *  希尔排序是在插入排序得基础上进行操作得:
     *
     *   1、初始化一个数组值   7 8 9 0 4 3 1 2 5 10
     *   2、进行增量分段： n/2  5，2，1
     *   3、第一次是5   然后在步长范围内进行排序，7和3 进行排序 3，7  第一次排序结果
     *   是3，1，2，0，4，7，8，9，5，10
     *   4、然后步长是2  [3,2,4,8,5] [1,0,7,9,10] 排序：
     *   5、最后是1
     *   总体来说还是一个插入排序，是一个分组得插入排序
     */

    public static void main(String[] args) {
        int[] a = {7 ,8 ,9, 0 ,4, 3, 1, 2, 5 ,10};
        int n = a.length;
        for (int add = n / 2; add >= 1; add /= 2) {
            for (int i = add; i < n; i++) { //第一个不用排序
                int data = a[i];
                int j = i - add;
                for (; j >= 0; j-= add) { //从后像前便于与I数组移动位置
                    if (a[j] > data) {
                        a[j + add] = a[j];
                    } else {
                        //找到了位置
                        break;//如果这个break执行的越多 那么我是不是效率就越高?
                    }
                }
                //找到了j的位置比data小的位置，插在后边；
                a[j + add] = data;

            }
            System.out.println("第" + add + "次的排序结果是：");
            for (int k = 0; k < n; k++) {
                System.out.print(a[k] + "  ");
            }
            System.out.println("");
        }
    }

}
