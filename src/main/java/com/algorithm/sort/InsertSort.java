package com.algorithm.sort;

public class InsertSort {

    /**
     * 1.将数组分成已排序段和未排序段。初始化时已排序端只有一个元素
     * 2.到未排序段取元素插入到已排序段，并保证插入后仍然有序
     * 3.重复执行上述操作，直到未排序段元素全部加完。
     * 分析下这个排序的问题：
     *   时间复杂度为n^2
     *   最好的情况：什么情况下：O(n);
     *   也就是一个排好顺序的队列
     */

    public static void main(String[] args) {
        int[] a = {1, 9, 7, 0, 3, 2, 5, 6};
        int  n= a.length;
        for (int i = 1; i < n; i++) { //第一个不用排序
            int data = a[i];
            int j =i-1;
            for ( ;j>=0;j--){ //从后像前便于与I数组移动位置
                 if (a[j]>data){
                     a[j + 1] = a[j];
                 }else {
                     //找到了位置
                     break;//如果这个break执行的越多 那么我是不是效率就越高?
                 }
            }
            //找到了j的位置比data小的位置，插在后边；
            a[j+1]=data;
            System.out.println("第"+i+"次的排序结果是：");
            for (int k = 0; k < n; k++) {
                System.out.print(a[k] + "  ");
            }
            System.out.println("");
        }
    }

}
