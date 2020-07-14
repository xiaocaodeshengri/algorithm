package com.algorithm.rec;

// 1,1,2,3,5,8,13
public class Fibonacci {

    private static int[] data =new int[46];

    public static int fab(int n){
         if(n<=2) return 1;
        int res = fab(n - 1) + fab(n - 2);
        return res;
    }

    public static int cacheFab(int n){
        if(n<=2) return 1;
        if(data[n] > 0){
            return data[n];
        }
        int res = cacheFab(n - 1) + cacheFab(n - 2);
        data[n]= res;
        return res;
    }

    public static int nofab(int n){
        if(n<=2) return 1;
        int a=1;
        int b=1;
        int c=0;
        for (int i = 3; i <= n; i++) {
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }

    /**
     * 阶乘运算
     * @param n
     * @return
     */
    public static int fac(int n) { // 求N的阶乘 用普通递归怎么写 5=5*4*3*2*1=> f(n) =
        if (n <= 1)
            return 1;
        return n * fac(n - 1);
    }

    /**
     *
     * @param n  运算次数
     * @param res  上次结果
     * @return
     */
    private static int tailFab2(int n,int res) {
        if(n<=1) return 1;

        /**
         * 5 --> 1
         * 4--->5
         * 3---->20
         * 2---->60
         * 1---->120
         */
        return tailFab2(n - 1, n * res);
    }


    public static int tailfab(int pre,int res,int n) { // 分析一段代码好坏，有两个指标，时间复杂度和空间复杂度 都是： O(n)
        if (n <= 2)
            return res; // 递归的终止条件
        return tailfab(res, pre + res, n - 1);		//JDK源码
        //参数：
        /**
         * n 是肯定有的
         * res 上一次运算出来结果
         * pre 上上一次运算出来的结果
         */
    }
    public static void main(String[] args) {
        //
        System.out.println("使用递归的方式方式：时间复杂度是2^n");
            for (int i = 0; i < 30; i++) {
            long start = System.currentTimeMillis();
            System.out.println("i"+i+"------>"+fab(i)+"花费时间："+(System.currentTimeMillis()-start)+"ms");
        }
        System.out.println("使用原始的方式：O(N)");
        for (int i = 0; i < 30; i++) {
            long start = System.currentTimeMillis();
            System.out.println("i"+i+"------>"+nofab(i)+"花费时间："+(System.currentTimeMillis()-start)+"ms");
        }
        System.out.println("使用缓存的方式：O(N)");
        for (int i = 0; i < 30; i++) {
            long start = System.currentTimeMillis();
            System.out.println("i"+i+"------>"+cacheFab(i)+"花费时间："+(System.currentTimeMillis()-start)+"ms");
        }
        System.out.println("使用尾递归的方式：O(N)");
        for (int i = 1; i <= 45; i++) {
            long start = System.currentTimeMillis();
            System.out.println(i + ":" + tailfab(1,1,i) + " 所花费的时间为"
                    + (System.currentTimeMillis() - start) + "ms");
        }
    }




}
