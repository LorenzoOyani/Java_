package org.example.Exercise;
/* Checking strings, use pointers and chartAt index*/

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringKdistinct {

    public int findDistinctK(String s, int k) {
        int sLen = s.length();
        int maxLength = 0;
        int start = 0;
        Map<String, Integer> hashmap = new HashMap<>();
        int mapSize = hashmap.size();
        for (int end = 0; end < sLen; end++) {
            char right = s.charAt(end);
            String string = Character.toString(right);
            if (!hashmap.containsKey(string)) {
                hashmap.put(string, hashmap.getOrDefault(string, 0) + 1);
            }
            while (mapSize > k) {
                // shrink left pointer to count distinct index by shrinking from the left;
                char left = s.charAt(start);
                String s1 = Character.toString(left);
                if (!hashmap.containsKey(s1)) {
                    hashmap.put(s1, hashmap.get(s1) - 1);
                    if (hashmap.get(s1) == 0) {
                        hashmap.remove(string);
                    }
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;


    }
}
