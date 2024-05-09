package org.example.Exercise;

public class newQueue {
    private final int MAX = 9;
    int[] queueArrays = new int[MAX];
    int right = queueArrays.length - 1;
    int left = 0;
    int countQueue = 0;

    public boolean isFull() {
        return countQueue == MAX;
    }

    public boolean isEmpty() {
        return countQueue == 0;
    }

    public void insert(int data) {
        if (!isFull()) {
            if (right == MAX - 1) {
                right = -1;
            }
        }
        queueArrays[++left] = data; //pre-increment to add new data to the queue;
        countQueue++;
    }

    int remove() {
        int data = queueArrays[left++];
        if (left == MAX) {
            left = 0;
        }
        countQueue--;
        return data;
    }
    int peek() {
        return queueArrays[left];
    }

}
