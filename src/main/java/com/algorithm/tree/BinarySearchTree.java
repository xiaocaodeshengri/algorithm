package com.algorithm.tree;

public class BinarySearchTree {

      int data;
      BinarySearchTree left;
      BinarySearchTree right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinarySearchTree getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTree left) {
        this.left = left;
    }

    public BinarySearchTree getRight() {
        return right;
    }

    public void setRight(BinarySearchTree right) {
        this.right = right;
    }

    public BinarySearchTree(int data) {
        this.data = data;
        this.left=null;
        this.right=null;
    }


    public static void main(String[] args) {
        int[] data = {0, 5, 9, 1, 2, 3, 10};
        BinarySearchTree root = new BinarySearchTree(data[0]);
        for (int i = 1; i <data.length ; i++) {
            root.insert(root,data[i]);
        }
        System.out.println("中序遍历：");
        root.in(root);
    }

    private void in(BinarySearchTree root) {
        if (root.left != null) {
            in(root.left);
        }
        System.out.print(root.data);
        if (root.right != null) {
            in(root.right);
        }
    }


    private void insert(BinarySearchTree root, int data) {
        if (root.data < data) {
            if (root.right == null) {
                root.right = new BinarySearchTree(data);
            }else {
                insert(root.right,data);
            }
        }else {
            if (root.left == null) {
                root.left = new BinarySearchTree(data);
            }else {
                insert(root.left,data);
            }
        }
    }
}
