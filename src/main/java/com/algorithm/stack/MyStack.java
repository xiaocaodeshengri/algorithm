package com.algorithm.stack;

public interface MyStack<E> {
    void push(E item);		//入栈

    E pop();	//出栈

    int size();		// 大小

    boolean isEmpty();
}
