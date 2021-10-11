package com.company;

public class MyList<T> implements DoubleLinkedList<T> {
    Node first;
    Node last;
    int size;

    public MyList() {
    }

    @Override
    public void addFirst(Object obj) {
        Node node = new Node((Integer) obj);
        if (first == null) {
            first = node;
            last = node;
        } else {
            first.prev = node;
            node.next = first;
            first = first.prev;
            first.next = node.next;
        }
        size++;
    }

    @Override
    public void addLast(Object obj) {
        add(obj);
    }

    @Override
    public void add(Object obj) {
        Node node = new Node((Integer) obj);
        if (first == null) {
            first = node;
            last = node;
            first.prev = null;
        } else {
            last.next = node;
            node.prev = last;
            last = last.next;
            last.prev = node.prev;
        }
        size++;
    }

    @Override
    public void removeFirst() {
        if (size == 1) {
            first = last = null;
        } else {
            Node temp = first.next;
            first = temp;
            temp.prev = null;
        }
        size--;

    }

    @Override
    public void removeLast() {
        if (size == 1) {
            first = last = null;
        } else {
            Node temp = last.prev;
            last = temp;
            temp.next = null;
        }
        size--;
    }

    @Override
    public void push(T obj) {
        addFirst(obj);
    }

    @Override
    public int pop() {
        int firstElement = first.element;
        removeFirst();
        return firstElement;
    }

    @Override
    public boolean offerFirst(T obj) {
        addFirst(obj);
        return first.element == obj;
    }

    @Override
    public boolean offerLast(T obj) {
        add(obj);
        return last.element == obj;
    }

    @Override
    public void descendingIterator() {
        Node node = new Node();
        Node node2 = last;
        Node node3 = first;
        for (int i = 0; i <= size / 2; i++) {
            if (i == 0) {
                node.element = last.element;
                last.element = first.element;
                first.element = node.element;
            } else {
                node.element = node2.element;
                node2.element = node3.element;
                node3.element = node.element;

            }
            node2 = node2.prev;
            node3 = node3.next;
        }
    }

    @Override
    public Integer poll() {
        Integer value = first.element;
        if (isEmpty()) {
            removeFirst();
        }
        return value;
    }

    @Override
    public Integer pollFirst() {
        return poll();
    }

    @Override
    public Integer pollLast() {
        Integer value = first.element;
        if (isEmpty()) {
            removeLast();
        }
        return value;
    }

    @Override
    public void iterator() {
        Node iList = first;
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                iList.prev = null;
            } else if (i == size - 1) {
                iList = last;
                iList.next = null;
            } else {
                assert iList != null;
                iList = iList.next;
            }
        }
    }

    public boolean isEmpty() {
        return first != null || last != null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = first;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            if (i < size - 1) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }
}
