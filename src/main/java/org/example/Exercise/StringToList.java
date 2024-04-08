package org.example.Exercise;

import java.util.ArrayList;
import java.util.Scanner;

public class StringToList {
    public static void main(String[] args) {
        StringToList myList = new StringToList();
        System.out.println(STR."The characters in this list is \{myList.displayList()}");


    }

    public ArrayList<String> displayList() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any word (enter exit to stop): ");
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String line = sc.nextLine();

            if (line.equalsIgnoreCase("exit")) {
                break;
            }
            for (int i = 0; i < line.length(); i++) {
                char firstChar = line.charAt(i);
                if (Character.isLetter(firstChar)) {
                    String substrings = Character.toString(firstChar);
                    if (!list.contains(substrings)){
                        list.add(substrings);
                    }
                }
            }

        }
        return list;
    }
}