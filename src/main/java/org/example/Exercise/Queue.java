package org.example.Exercise;

public class Queue {
    private int[] elements;
    private int size = 0;
    private int capacity;

    Queue(int capacity) {
        this.capacity = capacity;
    }

    Queue() {
        this(8);
        elements = new int[size];
    }

    public void enqueue(int v) {
        if (size > elements.length - 1) {
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        for (int i = 0; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size] = v;
        size++;
    }

    public void dequeue() {
        if (size > 0) {
            for (int i = 0; i < size - 1; i++) {
                elements[i + 1] = elements[i];
            }
            elements[size - 1] = 0;
            size--;
        } else {
            System.out.println("no elements present in queue");
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int get() {
        return size;
    }
}
