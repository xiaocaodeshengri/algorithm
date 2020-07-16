package com.algorithm.tree;


import java.util.Arrays;

/**
 *
 * 插入：是上浮的过程
 * 删除：是下沉的过程
 * 堆调整：也是下沉的过程
 *
 */
public class HeapTree {


    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 2, 6, 5, 7, 8,9, 10, 0};
        upAdjust(a);
        System.out.println(Arrays.toString(a));
        int[] b = new int[]{7, 1, 3, 10, 5, 2, 8, 9, 6};
        bulidHeap(b);
        System.out.println(Arrays.toString(b));
    }

    private static void bulidHeap(int[] array) {
        //从最后一个非叶子节点做下沉处理
       for (int i= (array.length-2)/2;i>=0;i--){
           downAdjust(array,i,array.length);
       }
    }

    private static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = 2*parentIndex+1;
        while (childIndex < length) {
            //如果有有孩子而且右孩子的值小于左边的孩子则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            if (temp < array[childIndex]) {
                break;
            }
            array[parentIndex] = array[childIndex];
            //往下走
            parentIndex = childIndex;
            childIndex = childIndex*2+1;
        }
        array[parentIndex] = temp;

    }


    private static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        //最后一个值
        int temp = array[childIndex];
        while (temp < array[parentIndex] && childIndex > 0) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }

        array[childIndex] = temp;
    }


}
