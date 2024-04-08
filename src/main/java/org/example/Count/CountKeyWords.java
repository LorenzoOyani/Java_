package org.example.Count;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CountKeyWords {


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a word (exit to stop): ");
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("ext")) {
                break;
            }
            File file = new File(line);
            if (!file.exists()) {
                System.out.println("The file " + file + " does not exist");
                continue;
            }
            Map<String, Integer> wordCount = CountKeys(file);
            System.out.println("The word count is " + wordCount);

            for (Map.Entry<String, Integer> word : wordCount.entrySet()) {
                System.out.printf("%s%n%d%n", word.getKey(), word.getValue());
            }
        }


    }

    static Map<String, Integer> CountKeys(File file) throws FileNotFoundException {
        Map<String, Integer> wordCount = new HashMap<>();
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                String line = sc.next();
                wordCount.put(line, wordCount.getOrDefault(line, 0) + 1);
            }
            return wordCount;

        }


    }

//    public static long CountKeyWord(File file) throws FileNotFoundException {
////        Set<String> list = new HashSet<>();
//        List<String> list = new ArrayList<>();
//        int countWords = 0;
//        try (Scanner sc = new Scanner(file)) {
//            while (sc.hasNext()) {
//                list.add(sc.next().toLowerCase());
//            }
//            sc.nextLine();
//            Collections.sort(list);
//            String[] keywords = new String[]{"this", "if", "else", "new", "throws"
//                    , "static", "long", "try", "structs"
//            };
//            for (String keyword : keywords) {
//                int occurrences = Collections.frequency(list, keyword.toLowerCase());
//                countWords += occurrences;
//                System.out.println("The amount of " + keyword + ":" + occurrences);
//            }
//            System.out.println("The occurrences  " + countWords);
//        }
//        return countWords;
//    }

//    public static long CountKeyWord(File file) throws Exception {
//        int countWord = 0;
//        String[] keywords = new String[]{"this", "if", "else", "new", "throws"
//                , "static", "long", "try", "structs"
//        };
//        Set<String> keySets = new HashSet<String>(Arrays.asList(keywords));
//        Map<String, Integer> list = new HashMap<>();
//        for (String keySet : keySets) {
//            if (list.containsKey(keySet)) {
//                countWord++;
//                list.put(keySet, countWord);
//            }
//
//        }
//        // debugging entries;
//        for (Map.Entry<String, Integer> mapsEntries : list.entrySet()) {
//            System.out.printf("%s%n%d%n", mapsEntries.getKey(), mapsEntries.getValue());
//        }
//        return countWord;
//    }

}
