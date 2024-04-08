package org.example.Exercise;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class countWordOccurrence {
    public static void main(String[] args) throws ClassCastException {
        String text = "The Premier league is just as corrupt as La-liga, The bundesliga is a tinpot league.";
        Map<String, Integer> map = new TreeMap<>();
//        Set<String> list = new TreeSet<>();
        String[] word = text.split(".,;:!?");
        for (int i = 0; i < word.length; i++) {
            String key = word[i].toLowerCase();
            if (!key.isEmpty() && Character.isLetter(key.charAt(i))) {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    int value = map.get(key);
                    value++;
                    map.put(key, value);

                }
            }

        }
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(STR."\{entry.getKey()}\t\t \{entry.getValue()}");


        }

    }
}