package org.example.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

// records provides immutability, Encapsulation, and readability

public  record SortStreamCollections(int index, String name, float amount) {

    public static void main(String[] args) {
        List<SortStreamCollections> list = new ArrayList<>();
        list.add(new SortStreamCollections(1, "John ortega ", 45.65F));
        list.add(new SortStreamCollections(2, "Danzel washington ", 98.65F));
        list.add(new SortStreamCollections(3, "Jennifer Lawrence", 90.65F));

//        implementing lambdas
        Collections.sort(list, Comparator.comparing(p -> p.amount));





        for(int i =0; i < list.size(); i++){
            System.out.println(STR."\{i} \{list.get(i).amount}");
        }
        for (SortStreamCollections s : list) {
            System.out.println(STR."The sorted list is: \{s.index} \{s.name} \{s.amount}");
        }
        Stream<SortStreamCollections> streams = list.stream().filter(p -> p.amount > 80.43F);

        list.forEach(l -> System.out.println(STR."\{l.name}"));
        streams.forEach(p -> System.out.println(STR."\{p.amount} "));
    }

}