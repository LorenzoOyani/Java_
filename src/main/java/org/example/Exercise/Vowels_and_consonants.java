package org.example.Exercise;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Vowels_and_consonants {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("usage: get keyword from a file");
            System.exit(1);
        }
        File file = new File(args[0]);
        if (file.exists()) {
             CountVowelsAndConsonants(file);
        } else {
            System.out.println("The file " + file + "doesn't exist");
        }
    }

    public static void CountVowelsAndConsonants(File file) throws Exception{

        int countVowels = 0;
        int consonants = 0;
        Set<Character> set = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O','U'));
        try(Scanner input = new Scanner(file)){
            while(input.hasNext()){
                String line = input.nextLine();
                for(int  i = 0; i < line.length(); i++){
                    if(set.contains(Character.toUpperCase(line.charAt(i)))){
                        countVowels++;
                    } else if (Character.isLetter(line.charAt(i))) {
                        consonants++;
                    }
                }
            }
        }
        System.out.println("The file has " + countVowels + "vowels and "+ consonants + "consonants");

    }
}