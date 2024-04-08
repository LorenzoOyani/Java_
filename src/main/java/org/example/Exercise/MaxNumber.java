package org.example.Exercise;

import java.math.BigInteger;
import java.util.ArrayList;

public class MaxNumber {
    static Number maxList(ArrayList<Number> list) {
        if (list.isEmpty()) {
            return null;
        }
        Number max = list.getFirst();
        for (int i = 0; i < list.size(); i++) {
            if (max.doubleValue() < list.get(i).doubleValue()) {
                max = list.get(i);
            }
        }
        return max;

    }

    void main() {
        ArrayList<Number> list = new ArrayList<>();
        list.add(45.55);
        list.add(43.22);
        list.add(43433);
        list.add(new BigInteger("3456789"));
        System.out.println(STR."Max value of the list is \{maxList(list)}");
    }
}
