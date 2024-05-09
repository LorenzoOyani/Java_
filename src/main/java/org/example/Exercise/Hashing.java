package org.example.Exercise;

import java.util.HashMap;
import java.util.Map;

public class Hashing {

    private final int SIZE = 4;
    Map<Integer, DataItem> hashmap = new HashMap<>();


    // define the hashTable as an array of pointers.
    DataItem[] hashArrays = new DataItem[SIZE];

    int hashCode(int key) {
        return key % SIZE;
    }

    // insert into an empty arrays.
    void insert(int key) {
        int hashIndex = hashCode(key);
        DataItem newItem = new DataItem();
        newItem.key = key;
        while (hashmap.get(hashIndex) != null) {
            hashIndex++;

            hashArrays[hashIndex] = newItem;
            //wrapping around the table;
            hashIndex %= SIZE;
        }
    }

    DataItem delete(int key) {
        int hashIndex = hashCode(key);
        while (hashArrays[hashIndex] != null) {
            if (hashArrays[hashIndex].key == key) {
                DataItem temp = hashArrays[hashIndex];
                hashArrays[hashIndex] = null;
                return temp;
            }
            hashIndex++;
            hashIndex %= SIZE;
        }
        return null;
    }
    // searching an Array using an HashCode;

    DataItem search(int key) {
        int hashIndex = hashCode(key);

        while (hashmap.get(hashIndex) != null) {
            if (hashmap.get(hashIndex).key == key) {
                return hashmap.get(hashIndex);
            }
            hashIndex++;
            hashIndex %= SIZE;
        }

        return null;
    }

    void main() {
        DataItem item = new DataItem();
        item.key = 25;
        DataItem item1 = new DataItem();
        item1.key = 40;
        DataItem item2 = new DataItem();
        item2.key = 59;
        DataItem item3 = new DataItem();
        item3.key = 70;

        insert(35);
        insert(34);
        insert(90);

        for (int i = 0; i < SIZE; i++) {
            if (hashArrays[i] != null) {
                System.out.println(STR."The inserted keys\{i}is found!\{hashArrays[i].key}");
            } else {
                System.out.println("no keys found!");
            }
        }

        int keySearch = 70;
        DataItem newItem = search(keySearch);
        System.out.println(STR."Elements to be searched \{keySearch}");
        if (newItem != null) {
            System.out.println("Element found\n");
        } else {
            System.out.println("no such element found");
        }
    }

    static class DataItem {
        int key;
//        int data;
    }

}
