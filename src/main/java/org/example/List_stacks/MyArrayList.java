package org.example.List_stacks;

import java.util.Iterator;

/**
 * This class implements a list using an array
 */

public class MyArrayList<E> extends MyAbstractList<E> {
    public static final int INITIAL_CAPACITY = 16;
    private E[] data = (E[]) new Object[INITIAL_CAPACITY];

    public MyArrayList() {
    }  // no-arg constructor.

    public MyArrayList(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    @Override
    public void add(int index, E e) {
        ensureCapacity();
        // to add an element to an array, you increase the size of the list then add the elements
        for (int i = size - 1; i >= 0; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }


    public void ensureCapacity() {
        if (size > data.length) {
            E[] newDataLists = (E[]) new Object[size * 2 + 1];
            System.arraycopy(data, 0, newDataLists, 0, size);
            data = newDataLists;
        }


    }

    @Override
    public void clear() {
        data = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;

    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) return i;
        }
        return -1; // not present in the list.

    }

    @Override
    public int lastIndexOf(E e) {
        for (int i = size - 1; i >= 0; i--) {
            if (e.equals(data[i])) {
                return i; // return the last index of the object in the list
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) { // remove at index zero, hence you shift elements in the arrays to the right to remove.
//        if (index < 0 || index >= size) {
//            return null;
//        }
        checkIndex(index);
        E e = data[index];
        for (int i = 0; i < size; i++) {
            data[i + 1] = data[i];

        }
        data[size - 1] = null;
        size--;
        return e;
    }

    public void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(STR."index \{index}out of bounds");
        }
    }


    @Override
    public E set(int index, E e) {
        E oldIndex = data[index];
        data[index] = e;
        return oldIndex;
    }

    public void trimToSize() {
        if (size != data.length) {
            E[] arrSize = (E[]) new Object[size];
            System.arraycopy(data, 0, arrSize, 0, size);
            data = arrSize;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            if (i < size - 1) result.append(",");

        }
        return STR."\{result.toString()}]";
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {
        private int currentSize = 0;

        @Override
        public boolean hasNext() {
            return (currentSize < size);
        }

        @Override
        public E next() {
            return data[currentSize++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(currentSize);
        }
    }
}