package com.algorithm.link;

import java.sql.SQLOutput;

/**
 *
 * 双向的实现
 * 使用头插法
 */
public class DoubleLink<E> {


    private Node head;
    private int size;
    private Node tail;

    public DoubleLink() {
        this.size = 0;
    }
/**
 * 头插法
 */
    public void add(E e){
        Node node =new Node(e);
        if (head == null) {
            tail =node;
        }else {
            head.pre= node;
           node.next=head;
        }
         head=node;
       ++ size;
    }


    /**
     * 删除头部
     */
    public void remove(){
     if(head==null) return;
    if (head.next == null) {
        tail=null;
    }else {
        head.next.pre =null;
    }
        head=head.next;
     --size;
   }

    /**
     * 删除中间
     */
    public void remove(E e){
       Node cur = head;
       while (!cur.data.equals(e)){
           if (cur.next == null) {
               System.out.println("没有找到数据！");
           }
           cur = cur.next;
       }

       if(cur==head){
          remove();
       }else{
          cur.pre = cur.next.pre;
          cur.pre.next = cur.next;
       }
        --size;
    }


    /**
     * 获取数值
     */
    public void print(){
        Node cur = head;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    /**
     * 定义一个节点
     * 保存两个信息一个是下一个节点
     * 一个是节点的信息
     */
    class Node{

        private E data;

        private Node next;
        private Node pre;

        public Node(E data) {
            this.data = data;
            next=null;
            pre=null;
        }
    }

}
