package org.example.List_stacks;
/**
 * A class implements an interface, while an interface can extend as many interfaces as possible
 * */

public interface MyList<E> extends java.lang.Iterable<E> {
    void add(E e);
    void clear();
    boolean contains(E e);
    E get(int index);
    int indexOf(E e);
    boolean isEmpty();
    int lastIndexOf(E e);
    boolean remove(E e);
    E remove(int index);
    Object set(int index, E e);
    int size();



}