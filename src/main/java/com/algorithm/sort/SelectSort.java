package com.algorithm.sort;

public class SelectSort {

    public static void main(String[] args) {

        int[] a = {};
        int n=10;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n - 1; j++) {
                if (a[j] < a[i]) {
                    min = j;
                }
            }
            //swap(a[i],a[min])
        }
    }


}
