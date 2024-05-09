package org.example.EnumeratedTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatWords {
    public static List<Integer> getNonRepeatingWords(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int stringLen = s.length();
        int len = words[0].length();
        int wordLen = words.length;

        Map<String, Integer> hashmap = new HashMap<>();
        for (String word : words) {
            hashmap.put(word, hashmap.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= stringLen - wordLen * len; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            if (j < wordLen) {
                String newWord = s.substring((i + j) * len, i + (j + 1) * len);
                if (hashmap.containsKey(newWord)) {
                    seen.put(newWord, seen.get(newWord) + 1);
                    if (seen.get(newWord) > hashmap.getOrDefault(newWord, 0) + 1) {
                        break;
                    }


                } else {
                    break;
                }

                j++;
            }
            if (j == wordLen) {
                result.add(i);
            }

        }
        return result;

    }
}
