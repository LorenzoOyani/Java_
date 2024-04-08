package org.example.Exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class keywordJava {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            System.out.println("counting java keywords");
            System.exit(1);
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("The file " + args[0] + "doesn't exist");
            System.exit(2);
        } else {
            System.out.println("The counted keywords are " + countKeyWord(file));
        }

    }

    public static int countKeyWord(File file) throws FileNotFoundException {
        Set<String> list = getStrings();
        int count = 0;
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                String word = sc.next().toLowerCase();
                if (word.equals("\\")) {
                    sc.nextLine();
                } else if (word.equals("/*")) {
                    String nextword;
                    do {
                        nextword = sc.next();
                    } while (!nextword.contains("/*"));
                } else if (list.contains(word)) {
                    count++;
                }

            }
            return count;


        }
    }

    public static Set<String> getStrings() {
        String[] keywordString = {"abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum",
                "extends", "for", "final", "finally", "float", "goto",
                "if", "implements", "import", "instanceof", "int",
                "interface", "long", "native", "new", "package", "private",
                "protected", "public", "return", "short", "static",
                "strictfp", "super", "switch", "synchronized", "this",
                "throw", "throws", "transient", "try", "void", "volatile",
                "while", "true", "false", "null"};

        return new HashSet<>(Arrays.asList(keywordString));
    }


}