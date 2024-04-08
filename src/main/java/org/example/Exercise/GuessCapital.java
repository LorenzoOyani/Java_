package org.example.Exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * (Guess the capitals using maps) Rewrite Programming Exercise 8.37 to store
 * pairs of each state and its capital in a map. Your program should prompt the user
 * to enter a state and should display the capital for the state.
 * */
public class GuessCapital {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);

        Map<String, String> maps = new HashMap<>();
        maps.put("Lagos", "ikeja");
        maps.put("London", "New York");

        while(true){
            String input = sc.nextLine();
            String key = maps.get(input);
            if(key != null){
                System.out.println(STR."The key in \{input} is \{key}");
            } else {
                System.out.println(STR."The key in \{input} of \{key} does not exist");

            }
        }
    }

    }
