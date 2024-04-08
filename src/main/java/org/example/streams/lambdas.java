package org.example.streams;

import static java.util.Collections.addAll;

public class lambdas {
    public interface AddAll{
        public int add(int a, int b);
    }

    public static void main(String[] args){
        AddAll addAll = Integer::sum; // method references in Lambdas
        AddAll addAll1 =  Integer::max;
        AddAll addAll2 = Integer::min;
        System.out.println("sum: "+ addAll.add(200, 5));
        System.out.println("max: "+ addAll1.add(200, 5));
        System.out.println("min: "+ addAll2.add(200, 5));
    }
}