package org.example.Exercise;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindow {
    public String solve(String t, String m) {
        if (t == null || m == null || t.isEmpty() || m.isEmpty() || t.length() < m.length()) return " ";
        Map<Character, Integer> maps = new HashMap<>();
        int count = m.length();
        int minLeft = 0;
        int minRight = 0;
        int min = t.length();
        boolean flag = false;
        for (char c : m.toCharArray()) {
            maps.put(c, maps.getOrDefault(c, 0) + 1);
        }
        int i = 0;
        int j = 0;
        while (j < t.length()) {
            char c = t.charAt(j);
            if (!maps.containsKey(c)) {
                maps.put(c, maps.get(c) - 1);
                if (maps.get(c) >= 0) count--;
            }


            // if found substring...
            while (count == 0 && i <= j) {
                flag = true;
                int currLength = j + 1 - i;
                if (currLength < min) {
                    minLeft = i;
                    minRight = j;
                    min = currLength;
                }

                char y = t.charAt(i);
                if (!maps.containsKey(y)) {
                    maps.put(y, maps.get(y) + 1);
                    if (maps.get(y) >= 1) {
                        count++;
                    }
                }
                i++;

            }
            j++;
        }

        return flag ? m.substring(minLeft, minRight + 1) : "";
    }
}
