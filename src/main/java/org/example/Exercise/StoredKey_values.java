package org.example.Exercise;

import java.util.*;

public class StoredKey_values {
    public static void main(String[] args) {
        Map<String, Integer> list = new HashMap<>();
        createMap(list);
        displayMap(list);
    }

    static void createMap(Map<String, Integer> map) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a word bro!: ");
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("exit")) {
                break;
            }
            String[] tokens = line.split(""); // method to split a string to characters

            for (String word : tokens) {
                if (!word.isEmpty()) {
                    if (map.containsKey(word)) {
                        int count = map.get(word);
                        map.put(word, count + 1);

                    } else {
                        map.put(word, 1);
                    }
                }

            }
        }
    }

    static void displayMap(Map<String, Integer> map) {
        Set<String> keys = map.keySet();
        SortedSet<String> treeList = new TreeSet<>(keys);
        System.out.printf("%n map contains: %nKey\t\tvalue%n");
        for (String key : treeList) {
            System.out.printf("%-10s%10s%n", key, map.get(key));
        }

    }
}