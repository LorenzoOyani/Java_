package org.example.Exercise;

import org.example.streams.Streams;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

public class readWrite {
    void main() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("python");
        list.add("c");

        list.add("jay");

        for (String myList: list) {
            System.out.println(myList.toUpperCase());
        }
        list.remove("python");
        list.add("tangerine");
        System.out.println(list);

    }

}
