package org.example.Exercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class maxLinkedList {
    void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string of characters:  ");
        String inputCharacterList = sc.nextLine();
        List<Character> max = new LinkedList<>();

        for (int i = 0; i < inputCharacterList.length(); i++) {
            List<Character> list = new LinkedList<>();
            list.add(inputCharacterList.charAt(i));

            for (int j = i + 1; j < inputCharacterList.length(); j++) {
                if (inputCharacterList.charAt(j) > list.getLast()) {
                    list.add(inputCharacterList.charAt(j));
                }
            }
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }
        for (Character ch : max) {
            System.out.println(ch);
        }


    }
}
