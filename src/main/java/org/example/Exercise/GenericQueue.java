package org.example.Exercise;

import java.util.LinkedList;

public class GenericQueue<E> {
    void main() {
        GenericQueue<String> stack = new GenericQueue<>();
        stack.enqueue("lorenzo");
        stack.enqueue("Jerumeh");
        stack.enqueue("june");
        stack.dequeue();
    }
    private final LinkedList<E> list = new LinkedList<>();

    public void enqueue(E v) {
        list.add(v);
    }
    public void dequeue() {
        list.removeFirst();
    }
    @Override
    public String toString() {
        return STR."queue \{list.toString()}";
    }
}
