package org.example.Exercise;

import java.util.*;

/**
 * (Count the occurrences of numbers entered) Write a program that reads an
 * unspecified number of integers and finds the one that has the most occurrences.
 * The input ends when the input is 0. For example, if you entered 2 3 40 3 5 4 –3
 * 3 3 2 0, the number 3 occurred most often. If not one but several numbers have
 * the most occurrences, all of them should be reported. For example, since 9 and 3
 * appear twice in the list 9 30 3 9 3 2 4, both occurrences should be reported.
 */
public class CountNumbers {
    public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   System.out.println("Enter a value (enter 0 to exit): ");
   int value = sc.nextInt();
   Map<Integer, Integer>maps = new HashMap<>();
    do{
        if (value > 0) {
            if (!maps.containsKey(value)) {
                maps.put(value, maps.getOrDefault(value, 0) + 1);
            } else {
                int frequency = maps.get(value);
                frequency++;
                maps.put(value, frequency);
            }
        }
    }while(value != 0);
    int max = Collections.max(maps.keySet());
        Set<Map<Integer, Integer>> list = new HashSet<>();
        for (Map<Integer, Integer> entries : list) {
//        Integer.parseInt(entries.get(i))
        }
        }

    }