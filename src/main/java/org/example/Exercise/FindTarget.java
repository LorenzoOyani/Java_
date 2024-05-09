package org.example.Exercise;

import java.util.ArrayList;
import java.util.List;

public class FindTarget {
    private static  List<Integer> list = new ArrayList<>();

    public static boolean targets(List<Integer> pairs) {
        int left = 0;
        int right = pairs.size() - 1;
        int currentTarget = 9;
        boolean allowedPass = false;
        while (left != right) {
            int currentPointer = pairs.get(left) + pairs.get(right);
            if (currentPointer == currentTarget) {
                allowedPass = true;
                break;
            }
            if (!allowedPass) {
                left++;
            } else {
                right--;
            }
        }
        return allowedPass;

    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        boolean findTarget = targets(list);
        System.out.println(STR."targeted number in a list is: \{findTarget}");
    }
}
