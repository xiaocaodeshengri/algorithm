package com.algorithm.hash;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
public class BloomFilerTest {


    public static void main(String[] args) {
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), 10000000, 0.01);

        long start = System.currentTimeMillis();
        for(int i = 0 ; i < 10000000 ; i ++) {
            bloomFilter.put(i);
        }
        System.out.println((System.currentTimeMillis() - start) + ":ms");

        //检测误差率
        int t=0;
        for(int i = 20000000 ; i < 30000000 ; i++) {
		  if(bloomFilter.mightContain(i)) { t ++; } }
		  System.out.println("误差率:" + t/10000000);

    }


}
