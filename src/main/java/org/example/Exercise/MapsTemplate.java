package org.example.Exercise;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MapsTemplate {
    public List<Integer> findAverages(String firstChar, String secondChar) {
        List<Integer> result = new LinkedList<>();
        if (firstChar.length() > secondChar.length()) {
            return result;
        }
        int end = 0;
        int start = 0;
        Map<Character, Integer> maps = new HashMap<>();
        int count = maps.size();
        for (char c : firstChar.toCharArray()) {
            if (!maps.containsKey(c)) {
                maps.put(c, maps.getOrDefault(c, 0) + 1);
            }
        }

        while (end < secondChar.length()) {
            char c = secondChar.charAt(end);
            if (!maps.containsKey(c)) {
                maps.put(c, maps.get(c) - 1);
                if (maps.get(c) == 0) {
                    count--;
                }
            }
            end++;

            while (count == 0) {
                char tempC = secondChar.charAt(start);
                if (!maps.containsKey(tempC)) {
                    maps.put(tempC, maps.get(tempC) - 1);
                    if (maps.get(tempC) > 1) {
                        count++;
                    }

                }

                start++;
            }

        }
        return result;
    }
}
