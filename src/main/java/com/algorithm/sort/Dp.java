package com.algorithm.sort;

public class Dp {

    /**
     * Max(money[i]+res[i-1][w-weight[i]],res[i-1][w]);
     *
     * money[i]+res[i-1][w-weight[i]]:装这个物品
     * w-weight[i] :表示装完还剩下的空间
     * res[i-1][w-weight[i]]:表示装完后剩下的空间还能装的最大值，取上一次的结果。
     * Res[i-1][w]表示不装这个物品的值
     * @param args
     */
    public static void main(String[] args) {
        int[] value = {60, 100, 120};//价值
        int[] weight = {10, 20, 40}; //重量
        int w = 50; //you can olny take 50kg
        int n = 3;
        int[][] dp = new int[n + 1][w + 1];//n表示物品  w表示重量

        for (int i = 1; i <= n; i++) { // 物品的数量
            for (int cw = 1; cw <= w; cw++) { //split the weight
                if (weight[i - 1] < cw) {
                    dp[i][cw] = Math.max(value[i-1]+dp[i-1][cw-weight[i-1]],
                            dp[i-1][cw]);
                }else{
                    dp[i][cw] = dp[i-1][cw];
                    //这件物品没有装进去
                }
            }
        }
        System.out.println(dp[n][w]);
    }

}
