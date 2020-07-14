package com.algorithm.sort;

public class QuickSort {
    /***
     *   整体思路:
     *      45 28 80 90 50 16 100 10
     * 基准数：一般就是取要排序序列的第一个。
     * 第一次排序基准数：45
     * 从后面往前找到比基准数小的数进行对换：
     * 10 28 80 90 50 16 100 45
     * 从前面往后面找比基准数大的进行对换：
     * 10 28 45 90 50 16 100 80
     *
     *    10 28 16 90 50 45 100 80
     *    10 28 16 45 50 90 100 80
     * 以基准数分为3部分，左边的比之小，右边比之大：
     * {10 28 16} 45 {50 90 100 80}
     * 到此第一次以45位基准数的排序完成。
     *
     */
    public static void qSort(int[] data,int left,int right){
           //将第一个数作为基数
        int base = data[left];// 就是我们的基准数，取序列的第一个,不能用data[0]
        int ll = left;// 表示的是从左边找的位置
        int rr = right;// 表示从右边开始找的位置
           // 从后面往前找比基准数小的数,如果后边得数比基准数大则继续找

        while (ll < rr && data[rr] >= base) {
                --rr;
        }

        if (ll < rr) {
            //为啥是这个判断条件呢，证明是不满足data[rr]>=base才跳出循环的，准确定位到了第一小于基数的位置
            //交换rr的数值与base的数值
            data[ll] = data[ll] + data[rr];
            data[rr] = data[ll] - data[rr];
            data[ll] = data[ll] - data[rr];
             ll++;
        }
        // 从前面往前找比基准数小的数,如果前边得数比基准数小则继续找
        while (ll < rr && data[ll] <= base) {
            --ll;
        }

        if (ll < rr) {
            //为啥是这个判断条件呢，证明是不满足data[rr]<=base才跳出循环的，准确定位到了第一大于基数的位置
            //交换rr的数值与base的数值
            data[ll] = data[ll] + data[rr];
            data[rr] = data[ll] - data[rr];
            data[ll] = data[ll] - data[rr];
            rr--;
        }

        if (left <ll) {
            qSort(data, left, ll - 1);
        }
        if (ll <right) {
            qSort(data, ll + 1, right);
          }
        }

}
