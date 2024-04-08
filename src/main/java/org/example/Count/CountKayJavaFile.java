package org.example.Count;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CountKayJavaFile {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("usage: print keyword from java file");
            System.exit(1);
        }
        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("This file " + file + "doesn't exist");
            System.exit(2);
        }
        Map<String, Integer> keyWordsCount = CountKeyWordsInFile(file);
        System.out.println("The keywords in the file are " + keyWordsCount);

    }

    static Map<String, Integer> CountKeyWordsInFile(File file) throws FileNotFoundException {
        Set<String> keywords = getKeywords();

        Map<String, Integer> count = new HashMap<>();
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                String word = sc.next().toLowerCase();
                if (word.equals("/*")) {
                    while (sc.hasNext() && !sc.next().equals("*/")) {
                        sc.nextLine();
                    }
                } else {
                    if (keywords.contains(word)) {
                        count.put(word, count.getOrDefault(word, 0) + 1);
                    }
                }

            }

        }
        return count;
//            return count;

    }

    static Set<String> getKeywords() {
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

        return new HashSet<String>(Arrays.asList(keywordString));
    }


}