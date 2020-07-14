package com.algorithm.stack;



public class ArrayStack<E>  implements  MyStack<E>{

    private E[] data = (E[]) new Object[1]; //先设置大小
   // private Object[] data =  new Object[1]; //先设置大小

    private int size =0;

    public ArrayStack(int cap) {
        data = (E[]) new Object[cap];
    }

    public void push(E item) {
       judge();
       data[size++]= item;
    }

    /**
     * 判断空间大小是否够用不够用就扩容
     */
    private void judge() {
        if (this.size >= data.length) {
            resize(this.data.length *2);
        }
        if (this.size>0 && this.size < this.data.length/2){
            resize(this.data.length/2);
        }

    }

    /**
     * 扩容以及缩容
     * @param n
     */
    private void resize(int n) {
        E[] temp = (E[])new Object[n];
        System.arraycopy(data,0,temp,0,this.size);
        data= temp;
    }

    public E pop() {
        if (isEmpty())return null;
        E item = data[--size];
        data[size] =null;
        return item;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        if(size==0) return true;
        return false;
    }
}
