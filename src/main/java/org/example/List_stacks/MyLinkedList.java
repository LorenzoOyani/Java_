package org.example.List_stacks;

import java.util.Iterator;

public class MyLinkedList<E> extends MyAbstractList<E> {
    private Node<E> head, tail;

    MyLinkedList() {

    }

    public MyLinkedList(E[] objects, Node<E> head, Node<E> tail) {
        super(objects);
        this.head = head;
        this.tail = tail;
    }


    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;

        if (tail != null) {
            tail = head;
        }

    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    @Override
    public void add(int index, E e) {
        if (index == 0) addFirst(e);
        if (index >= size) addLast(e);
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
        }


    }


    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return temp.element;
        }

    }

    public E removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;


        } else {
            Node<E> current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
                Node<E> temp = tail;
                tail = current;
                tail.next = null;
                size--;
                return temp.element;
            }
        }
        return null;
    }


    public E getFirst() {
        if (size == 0) return null;
        else return head.element;

    }

    public E getLast() {
        if (size == 0) return null;
        else return tail.element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            assert current != null; // null-safe checks.
            sb.append(current.element);
            current = current.next;

            if (current != null) sb.append(",");
            else sb.append("]");
        }
        return sb.toString();


    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int indexOf(E e) {
        return 0;
    }

    @Override
    public int lastIndexOf(E e) {
        return 0;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size) return null; // out of bounds
        if (index == 0) removeFirst();
        else if (index >= size - 1) removeLast();
        else {
            Node<E> previous = head;
            for (int i = 1; i < size; i++) {
                previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next; // this line removes from the list
            size--;
            return current.element;

        }
        return null;

    }

    @Override
    public Object set(int index, E e) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}