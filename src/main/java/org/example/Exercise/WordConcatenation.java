package org.example.Exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordConcatenation {
    List<Integer> findConcatWord(String s, String[] words) {
        // create a Map to store the first char of the word array.
        Map<String, Integer> maps = new HashMap<>();
        for (String word : words) {
            maps.put(word, maps.getOrDefault(word, 0) + 1);
        }
        final List<Integer> result = new ArrayList<>();
        int num = words.length;
        int i = 0;
        int j = 0;
        int len = words[0].length();
        int n = s.length();
        for (; i < n - num * len + 1; i++) {
            final Map<String, Integer> seen = new HashMap<>();
            while (j < num) {
                final String newWordCount = s.substring(i + j * len, i + (j + 1) * len);
                if (maps.containsKey(newWordCount)) {
                    seen.put(newWordCount, maps.get(newWordCount) + 1);
                    if (seen.get(newWordCount) > maps.getOrDefault(newWordCount, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                result.add(i);
            }
        }
        return result;

    }
}
