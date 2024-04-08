package org.example.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args){
        Set<Integer> list = new TreeSet<>(Arrays.asList(2, 3, 5 ,7 ,8 ,9));
        Stream<Integer> values = list.stream();
        list.add(34);
        values.map(value -> value * 2);
        List<String> collectors = new ArrayList<>(Arrays.asList("lawrencium", "James", "Curry"));
        collectors.stream().filter(s ->s.startsWith("J")).forEach(System.out::println);

        Stream<String> line = collectors.stream();
        collectors.add("John");
        String l = line.collect(Collectors.joining());


    }
}