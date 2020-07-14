package com.algorithm.link;

import javax.sql.DataSource;

/**
 * 使用数组实现
 * @param <E>
 */
public class MyArrayList<E> implements MyList<E>  {

    private static final int DEFAULT_CAPATITY = 10;

    private Object[] data;

    private int size;

    private int index;

    public MyArrayList() {
        data = new Object[DEFAULT_CAPATITY];
        this.size =DEFAULT_CAPATITY;
        this.index = 0;
    }

    public void add(E e) {
        //判断下长度，扩容
        judgeSize();
        data[index++] = e;
    }

    private void judgeSize() {
        if (index >= size) {
            Object[] temp = new Object[size * 2];
            this.size= size*2;
            System.arraycopy(data,0,temp,0,index);
            this.data=temp;
        }
    }

    public void remove(E e) {
        for (int i = 0; i < index; i++) {
            if(data[i].equals(e)){
              remove(i+1);
              break;
            }
        }

    }

    public void remove(int loc) {
       if(loc >0 &&loc<index){
            for(int j = loc;j<index-1;j++){
                data[j - 1] = data[j];
            }
            this.index --;
       }
    }

    public int size() {
        return this.size;
    }

    public int index() {
        return this.index;
    }

    public boolean isEmpty() {
         boolean flag=index()>0 ?false:true;
         return flag;
    }

    public E get(int index) {
       return (E)data[index];
    }

    public void print() {
       for(int i =0;i<this.size;i++){
           System.out.println("i"+i+"---->"+data[i]);
       }
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        System.out.println(list.size());
        System.out.println(list.isEmpty());

        Integer integer = new Integer(5);
        list.remove(integer);
        System.out.println(list.index());
        list.print();
    }
}
