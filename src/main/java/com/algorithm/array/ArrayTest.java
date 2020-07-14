package com.algorithm.array;


/**
 * 写一个arraylist
 *   实现基本功能  增  删  改 查
 *
 *
 *   这个数组有个缺点：
 *       不能接收int以外的类型
 *       没有扩容的机制
 */
public class ArrayTest {
     private int size; //目前数组的大小
     private int[] object;
     private int index;//目前已经存储数据大小

    //初始化一个数组
    public ArrayTest(int size) {
        this.size =size;
         object = new int[size];
         index =0;
    }

    /**
     * 不指定位置的新增
     * @param data
     */
    public void add(int data){
        if((index +1)<size){
            object[index++] =data;
        }
    }

    /**
     * 不指定位置的新增
     * @param data
     */
    public void add(int loc,int data){
        if(index++ <size){
           //将loc位置以后的数据往后移动一个位置
            for (int i = size-1; i >loc; i--) {
                object[i] = object[i - 1];
            }
            object[loc] = data;
        }
    }

    public void delete(int loc){
            //将loc位置以后的数据往后移动一个位置
            for (int i = size-1; i >loc; i--) {
                object[i-1] = object[i];
            }
        --index;
    }

    public int get(int loc){
          return object[loc];
        }

    public void update(int loc,int data){
        //将loc位置以后的数据往后移动一个位置
        object[loc] = data;
    }


    public void print(){
        System.out.println("index:" + index);
        for(int i = 0 ; i < size ; i++){
            System.out.print(object[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ArrayTest test = new ArrayTest(10);
        test.add(11);
        test.add(22);
        test.add(33);
       test.add(5,5);
        test.add(6, 6);
        test.print();
        test.delete(6);
        test.print();
    }

    }
