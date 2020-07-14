package com.algorithm.basic;

public class Caculate2 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8,9,10};
        System.out.println("方法一");
        mod2(a);
        System.out.println("方法二");
        array2(a);
    }

    /**
     * 使用数组方式进行解决
     *         解题思路：2 --->10  4--->100  8--->1000   16--->10000
     *                   1--->01  3---> 011 7--->0111   16--->01111
     *
     *         & 运算：两个数都转为二进制，然后从高位开始比较，如果两个数都为1则为1，否则为0。
     *         | 运算：两个数都转为二进制，然后从高位开始比较，两个数只要有一个为1则为1，否则就为0。
     *         ^ 运算：两个数转为二进制，然后从高位开始比较，如果相同则为0，不相同则为1。
     *         ~ 运算：如果位为0，结果是1，如果位为1，结果是0.
     *   进行&运算
     * @param a
     */

    private static void array2(int[] a) {
        for (int item:a) {
            System.out.print("item" +item);
            boolean flag = false;
            if (item!=1 && (item &(item-1))==0) flag = true;
            System.out.println("---"+flag);
        }
        
    }

    /**
     * 解题思路：如果不能被2整除直接的返回false
     *           如果是可以被2整除，可以递归的继续整除2
     *
     *   时间复杂度是O（n）
      * @param a
     */

    private static void mod2(int[] a) {
        for (int item:a) {
            System.out.print("item"+item);
            Boolean flag =false;
            while (item > 1) {
               flag =item %2 ==0? true:false;
               if(!flag)break;
               item /=2;
            }
            System.out.println("---"+flag);
        }
    }




}
