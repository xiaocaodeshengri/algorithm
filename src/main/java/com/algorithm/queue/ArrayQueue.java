package com.algorithm.queue;

/**
 * 整体思路：
 *    使用数组实现：
 *      有一个头
 *      一个尾部
 *      存放数据的地方
 *      数组的大小
 *      当前存储了几个数据
 */
public class ArrayQueue {

    private  int[] data;
   private int head = 0;
   private int tail = 0;
   private int n = 0; //数组大小
   private int size ; //当前已经存放了几个数据

    public ArrayQueue(int cap) {
        data = new int[cap];
        this.n = cap;
    }
    public void push(int m){
        if(tail==n){
            //如果tail移动到了数组的最后，先去整理数组
            judge();
           if(tail==n){
             return;
           }
        }
        data[tail]=m;
        tail++;
    }

    private void judge() {
        int[] temp = new int[n];
        int j=0;
        for (int i = head; i < tail; i++) {
            temp[j++] = data[i];
        }
        head=0;
        tail=temp.length-1;
        data= temp;
    }

    /**
     * 这个有个问题只是head的指针往后移动了，但是数组中的值并没有清空
     * @return
     */
    public int pop( ){
        if (isEmpty()) return -1;
        int m = data[head];
        head++;
        return m;
    }


    public boolean isEmpty( ){
         if (head==tail) return true;
         return false;
    }
}
