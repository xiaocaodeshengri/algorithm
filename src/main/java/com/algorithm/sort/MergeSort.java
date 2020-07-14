package com.algorithm.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] data = {9, 6, 4, 2, 0, 7, 8, 3};
        mergeSort(data, 0,data.length-1);
        System.out.println(Arrays.toString(data));
    }

    /**
     *  整体思路：
     *      查看上课画的图：
     *        1、讲data分成左右两部分，进行递归的划分，一直划分，到不能分位置
     *        2、划分完成后，对其进行归并排序
     * @param data
     * @param left
     * @param right
     */
    private static void mergeSort(int[] data, int left, int right) { //数组的两端
        if (left < right) {
            int mid = (left+right)/2;
            //先进行分组
            mergeSort(data, left, mid );
            mergeSort(data,mid+1,right);
            //在进行合并
            merge(data,left,mid,right);
        }
    }

    private static void merge(int[] data, int left, int mid, int right) {
        /**
         * 整体思路：
         *     1、创建一个临时数组保存数据；
         *     2、如果左边的排序号的是5 9  右边的是 6 8 ，那么创建两个指针，分别指向左边和右边
         *     创建一个变量保存临时数组的中的指针位置
         *     3、比较排序
         *     4、讲临时数组给data
         */

        int[] temp = new int[data.length]; //创建这样的大小主要是最后一次的排序
        int pointLeft  = left;
        int pointRight = mid+1;
        int loc = left;
        while(pointLeft <= mid && pointRight<=right){
             if (data[pointLeft] >= data[pointRight]){
                 temp[loc++] = data[pointRight++];
             }else{
                 temp[loc++] = data[pointLeft++];
             }
        }

        while (pointLeft<=mid){
            temp[loc++] = data[pointLeft++];
        }

        while (pointRight<=mid){
            temp[loc++] = data[pointRight++];
        }
        for(int i = left ; i <= right ; i++){
            data[i] = temp[i];
        }

    }

}
