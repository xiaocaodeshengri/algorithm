package com.algorithm.link;

/**
 * 定义好接口使用array和Link两种方式实现
 * @param <E>
 */
public interface MyList<E> {
    public void add(E e);
    public void remove(E e);
    public void remove(int loc);
    public int size();
    public boolean isEmpty();
    public E get(int index);
}
