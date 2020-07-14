package com.algorithm.basic;

/**
 * 这个类主要是用来看时间复杂度是怎么计算
 */
public class BigO {


    public static void main(String[] args) {
        System.out.println("time complex is : O(1)");
        O1();
        System.out.println("time complex is : O(logn)");
        Ologn();
        System.out.println("time complex is : O(n)");
        On();
        System.out.println("time complex is : O(nlogn)");
        Onlogn();
        System.out.println("time complex is : O(n^2)");
        On2();
    }

    private static void On2() {
        int n =Integer.MAX_VALUE;
        for(int j = 1;j<n;j++) {
            for(int i = 1;j<n;j++){
                //.....
            }
        }

    }

    private static void Onlogn() {
        int n =Integer.MAX_VALUE;
        int i =1;
        for(int j = 1;j<n;j++) {
            while (i < n) {
                i *= 2;
            }
        }
    }

    /**
     * 循环了N次
     */
    private static void On() {
        int n =Integer.MAX_VALUE;
        for (int i = 0;i<n;i++){
            //.......
        }
    }

    /**
     * 计算方法2^x = n ; x = logn
     */
    private static void Ologn() {
        int n =Integer.MAX_VALUE;
        int i =1;
       while (i<n){
           i *=2;
       }
    }

    /**
     * 当确定确切的数字时就是O（1）
     */
    private static void O1() {
        for (int i = 0 ;i<3;i++){
            System.out.println(i);
        }
    }


}
