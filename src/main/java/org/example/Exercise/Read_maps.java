package org.example.Exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Read_maps {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: print files ");
            System.exit(1);
        }
        File file = new File(args[0]);
        if (file.exists()) {
            System.out.println("file" + file + "exists");
            System.exit(1);
        }
        Map<String, Integer> maps = new TreeMap<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String[] line = sc.nextLine().split("[ \n\t\r\"'.,;:!?()]");
                storeKeys(maps, line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(STR."file not found \{e.getMessage()}");
        }
        Set<Map.Entry<String, Integer>> entry = maps.entrySet();
        for (Map.Entry<String, Integer> entries : entry) {
            System.out.println(STR."\{entries.getKey()}\t\{entries.getValue()}");
        }
    }

    public static void storeKeys(Map<String, Integer> maps, String[] word) {
        for (int i = 0; i < word.length; i++) {
            String key = word[i].toLowerCase();
            if (!key.isEmpty() && Character.isLetter(key.charAt(i))) {
                if (!maps.containsKey(key)) {
                    maps.put(key, 1);
                } else {
                    int value = maps.get(key);
                    value++;
                    maps.put(key, value);
                }
            }
        }
    }

}

