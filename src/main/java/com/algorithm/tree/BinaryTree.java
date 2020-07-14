package com.algorithm.tree;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class BinaryTree {

    public static void main(String[] args) {
        MyTreeNode D = new MyTreeNode('D', null, null);
        MyTreeNode H = new MyTreeNode('H', null, null);
        MyTreeNode K = new MyTreeNode('K', null, null);
        MyTreeNode C = new MyTreeNode('C', D, null);
        MyTreeNode G = new MyTreeNode('G', H, K);
        MyTreeNode B = new MyTreeNode('B', null, C);
        MyTreeNode F = new MyTreeNode('F', G, null);
        MyTreeNode E = new MyTreeNode('E', null, F);
        MyTreeNode A = new MyTreeNode('A', B, E);

        BinaryTree binaryTree = new BinaryTree();
        System.out.println("前");
        binaryTree.pre(A);
        System.out.println();
        System.out.println("中");
        binaryTree.in(A);
        System.out.println();
        System.out.println("后");
        binaryTree.post(A);
        System.out.println("层次");
        binaryTree.cengci(A);
    }

    private void post(MyTreeNode myTreeNode) {
        if (myTreeNode.getLeft() != null) {
            post(myTreeNode.getLeft());
        }
        if (myTreeNode.getRight() != null) {
            post(myTreeNode.getRight());
        }
        print(myTreeNode);
    }

    private void in(MyTreeNode myTreeNode) {
        if (myTreeNode.getLeft() != null) {
            in(myTreeNode.getLeft());
        }
        print(myTreeNode);
        if (myTreeNode.getRight() != null) {
            in(myTreeNode.getRight());
        }
    }

    public void print(MyTreeNode myTreeNode) {
        System.out.print(myTreeNode.getData());
    }

    public void pre(MyTreeNode myTreeNode) {
        print(myTreeNode);
        if (myTreeNode.getLeft() != null) {
            pre(myTreeNode.getLeft());
        }
        if (myTreeNode.getRight() != null) {
            pre(myTreeNode.getRight());
        }
    }
    public void cengci(MyTreeNode myTreeNode) {
        Queue<MyTreeNode> queue = new LinkedBlockingQueue<MyTreeNode>();
        queue.add(myTreeNode);

        while (!queue.isEmpty()) {
            MyTreeNode poll = queue.poll();
            print(poll);
            if (poll.getLeft() != null) {
                queue.offer(poll.getLeft());
            }
            if (poll.getRight() != null) {
                queue.offer(poll.getRight());
            }
        }


    }



}

class MyTreeNode{


    private char data;

    private MyTreeNode left;
    private MyTreeNode right;

    public MyTreeNode(char data, MyTreeNode left, MyTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public MyTreeNode getLeft() {
        return left;
    }

    public void setLeft(MyTreeNode left) {
        this.left = left;
    }

    public MyTreeNode getRight() {
        return right;
    }

    public void setRight(MyTreeNode right) {
        this.right = right;
    }


}



