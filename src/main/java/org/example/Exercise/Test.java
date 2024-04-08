package org.example.Exercise;

import java.util.Comparator;

public class Test {
    void main() {
//        Comparator<Integer> add = Test::add;
        int l = Test.add(3, 4);   // static method call
        System.out.println(l + " ");
    }

        public static int add(int a, int b) { // Static method
            return a + b;
        }


}
