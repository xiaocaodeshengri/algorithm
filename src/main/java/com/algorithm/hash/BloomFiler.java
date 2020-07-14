package com.algorithm.hash;

import java.util.BitSet;

public class BloomFiler {

    int size;
    BitSet bits; //包装好的byte[] 数组

    public BloomFiler(int size) {
        this.size = size;
        bits = new BitSet(size);
    }


    public void add(String key) {
        int hash1 = hash_1(key);
        int hash2 = hash_2(key);
        int hash3 = hash_3(key);
        bits.set(hash1,true);
        bits.set(hash2,true);
        bits.set(hash3,true);

    }

    private boolean find(String key) {
        int hash1 = hash_1(key);
        if (!bits.get(hash1)) {
            return false;
        }
        int hash2 = hash_3(key);
        if (!bits.get(hash2)) {
            return false;
        }
        int hash3 = hash_3(key);
        if (!bits.get(hash3)) {
            return false;
        }
        return true;
    }

    public int hash_1(String key) {
        int hash = 0;
        int i;
        for (i = 0; i < key.length(); ++i) {
            hash = 33 * hash + key.charAt(i);
        }
        return Math.abs(hash) % size;
    }

    public int hash_2(String key) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash ^ key.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return Math.abs(hash) % size;
    }

    public int hash_3(String key) {
        int hash, i;
        for (hash = 0, i = 0; i < key.length(); ++i) {
            hash += key.charAt(i);
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash += (hash << 15);
        return Math.abs(hash) % size;
    }

    public static void main(String[] args) {
        // O(1000000000)
        //8bit= 1byte
        BloomFiler bloomFilter = new BloomFiler(Integer.MAX_VALUE);	//21亿
        System.out.println(bloomFilter.hash_1("1"));
        System.out.println(bloomFilter.hash_2("1"));
        System.out.println(bloomFilter.hash_3("1"));


        bloomFilter.add("1111");
        bloomFilter.add("1123");
        bloomFilter.add("11323");

        System.out.println(bloomFilter.find("1"));
        System.out.println(bloomFilter.find("1123"));
    }


}
