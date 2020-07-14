package com.algorithm.hash;

public class BitMap {

     byte[] bits;
     int max;

    public BitMap(int max) {
        this.max = max;
        bits = new byte[(max >> 3) + 1];
    }

    public void add(int n) {
        int bitIndex = n >> 3; ///8是因为byte是8个字节
        int loc = n % 8; //确定在数组中的位置
        bits[bitIndex] |= 1<<loc;
    }

    public boolean find(int n) {
        int bitIndex = n >> 3; ///8是因为byte是8个字节
        int loc = n % 8; //确定在数组中的位置
       int flag= bits[bitIndex] & (1<<loc);
        if (flag == 0) {
            return false;
        }
        return  true;
    }

    public static void main(String[] args) {
        BitMap bit = new BitMap(2000000);
        bit.add(2);
        bit.add(3);
        bit.add(66);
        bit.add(65);
        System.out.println(bit.find(66));
        System.out.println(bit.find(64));

    }

}
