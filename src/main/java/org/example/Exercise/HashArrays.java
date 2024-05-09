package org.example.Exercise;

import java.util.HashMap;
import java.util.Map;

public class HashArrays {
    private final int SIZE = 4;
    DataItem[] hashArray = new DataItem[SIZE];

    // search the data item using the hashcode.
    int hashcode(int key) {
        return key % SIZE;
    }

    DataItem search(int key) {
        int hashKeyIndex = hashcode(key);
        while (hashArray[hashKeyIndex] != null) {
            if (hashArray[hashKeyIndex].key == key) {
                return hashArray[hashKeyIndex];

            }
            hashKeyIndex = (hashKeyIndex + 1) % SIZE;
        }
        return null;

    }

    void insert(int key) {
        DataItem item = new DataItem(key);
        item.key = key;
        int hashKeyIndex = hashcode(key);
        while (hashArray[hashKeyIndex] != null && hashArray[hashKeyIndex].key != -1) {
            hashKeyIndex = (hashKeyIndex + 1) % SIZE;
        }
        hashArray[hashKeyIndex] = item;
    }

    DataItem delete(DataItem item) {
        int key = item.key;
        DataItem dummyItem = new DataItem(-1);

        int hashKeyIndex = hashcode(key);
        while (hashArray[hashKeyIndex] != null) {
            if (hashArray[hashKeyIndex].key == key) {
                DataItem temp = hashArray[hashKeyIndex];
                hashArray[hashKeyIndex] = dummyItem;
                return temp;
            }
        }
        return null;
    }

    static class DataItem {
        int key;

        DataItem(int key) {
            this.key = key;
        }
    }

}
