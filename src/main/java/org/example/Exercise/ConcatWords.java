package org.example.Exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Return a list of concatenation strings of words, this returns all starting indexes of the s string*/
public class ConcatWords {
    public List<Integer> findTheNonRepeatWords(String s, String[] words) {
        final List<Integer> result = new ArrayList<>();
        int wordLength = words.length;
        int sLen = s.length();
        int i;
        int len = words[0].length();
        final Map<String, Integer> hashmap = new HashMap<>();
        // specify a default index bucket for the words[word];
        for (String word : words) {
            hashmap.put(word, hashmap.getOrDefault(word, 0) + 1);
        }
        // iterate through the index of the given words using index;
        // Iterate through the indexes of the string 's'
        for (i = 0; i <= sLen - wordLength * len; i++) {
            // create another Map to store the new substring for comparing and concatenation.
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            // Check each substring of length 'len' starting from index 'i'
            while (j < wordLength) {
                final String newWord = s.substring(i + j * len, i + (j + 1) * len);
                if (hashmap.containsKey(newWord)) {
                    seen.put(newWord, seen.get(newWord) + 1);
                    if (seen.get(newWord) > hashmap.getOrDefault(newWord, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == wordLength) {
                result.add(i);
            }
        }


        return result;
    }
}
