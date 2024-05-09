package org.example.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class maxList {
    void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string of characters: ");
        String string = sc.nextLine();
        List<Character> initialList = new ArrayList<>();
        List<Character> max = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            if (initialList.size() > 1 && string.charAt(i) <= initialList.getLast() && initialList.contains(string.charAt(i))) {
                initialList.clear();
            }
            initialList.add(string.charAt(i));

            if (initialList.size() > max.size()) {
                max.clear();
                max.addAll(initialList);
            }

        }

        for (Character ch : max) {
            System.out.println(STR."max characters in the list  \{ch}");
        }
    }
}
