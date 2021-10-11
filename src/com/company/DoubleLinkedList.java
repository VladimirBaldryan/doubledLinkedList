package com.company;

public interface DoubleLinkedList<T> {
    void addFirst(T obj);

    void addLast(T obj);

    void add(T obj);

    void removeFirst();

    void removeLast();

    void push(T obj);

    int pop();

    boolean offerFirst(T obj);

    boolean offerLast(T obj);

    void descendingIterator();

    Integer poll();

    Integer pollFirst();

    Integer pollLast();

    void iterator();

}
