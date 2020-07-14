package com.algorithm.link;

/**
 * 单链表的实现
 * 使用头插法
 */
public class MyLinkList<E> {


    private Node head;
    private int size;

    public MyLinkList() {
        this.size = 0;
    }
/**
 * 头插法
 */
    public void add(E e){
        Node node =new Node(e);
        node.next=head;
        head=node;
       ++ size;
    }

    /**
     * 中间插入
     */
    public void add(int loc,E e){
        if (loc == 0) {
            add(e);
        }else {
            Node newNode = new Node(e);
            Node cur = head;
            for (int i = 1; i < loc; i++) {
                cur = cur.next;
            }
            //重要逻辑
            newNode.next= cur.next;
            cur.next=newNode;
        }
    }

    /**
     * 删除头部
     */
    public void remove(){
     head= head.next;
     --size;
   }

    /**
     * 删除中间
     */
    public void remove(int loc){
        Node cur = head;
        for(int i =1;i<loc;i++){
          cur = cur.next;
        }
        cur.next = cur.next.next;
        --size;
    }

    /**
     * 获取数值
     */
    public E get(E e){
       Node cur =head;
       while (cur!=null){
           if(cur.data.equals(e)){
               return cur.data;
           }
       }
       return null;
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

        public Node(E data) {
            this.data = data;
            next=null;
        }
    }


    public static void main(String[] args) {
        MyLinkList<Integer> myList = new MyLinkList();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(8);
        myList.add(9);
        myList.add(10);
        myList.add(11);
        myList.add(12); myList.add(13); myList.add(14);
        myList.print(); // 10 -> 7 -> 5
        myList.remove(1);
        myList.print(); // 10 -> 5
        myList.remove();
        myList.print(); // 5
        myList.add(11, 1);
        myList.print(); // 5 -> 11
        myList.remove(1);
        myList.print(); // 5
    }


}
