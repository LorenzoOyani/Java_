package org.example.Exercise;

import java.util.*;

/**
 * The concrete classes for implementing sets Collection is
 * HashSets, LinkedHashSets, TreeSets
 *
 * HashSets default load factors - 0 and 1
 * Load factor of 0.75 is a trade-off and makes sense and come in handy with Hashing.
 * A HashSet can be used to store duplicates-free elements, for efficiency objects added to the HashSets
 * need to implement the hashCode method
 *
 * Elements can be compared in two ways using the comparable and the comparator interfaces
 * **/
public class Sets_DataStructure {
    public static void main(String[] args) {
        Set<String> list = new HashSet<>();
        list.add("John");
        list.add("Lennon");
        list.add("Jim");
        list.add("Reeves");
        list.add("faq");
        list.add("Lawrence");
// new sets upwards.
        Set<String> list2 = new HashSet<>();
        list2.add("mack");
        list2.add("Jane");
        list2.add("Lorenzo");

        list.addAll(list2);
        System.out.println(list);
//        Collections.sort(list);
//        List<String> listss = new ArrayList<>(Arrays.asList(list))


        TreeSet<String> tree  = new TreeSet<>(list);
        System.out.println(STR."first : \{tree.first()}");
        System.out.println(STR."last :\{tree.last()}");
        System.out.println(STR."headSets \{tree.headSet("Lawrence")}");

    }
}