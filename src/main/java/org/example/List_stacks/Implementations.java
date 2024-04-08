package org.example.List_stacks;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Implementations {
    void main(){
        MyList<String> list = new MyArrayList<>();
        list.add("John");
        list.add("peter");
        list.add("James");

        for (String e : list) {
            System.out.println(e);
        }
        list.set(1, "Lawrence");
        System.out.println(list);
//        Set<String> set = new TreeSet<>();
        String newList = list.remove(2);

        System.out.println(newList);

    }
}