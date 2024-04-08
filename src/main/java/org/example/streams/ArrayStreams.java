//package org.example.streams;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class ArrayStreams {
//    public static void main(String[] args) {
//
//        String line = "The Great Gatsby";
//        String text = line.toLowerCase();
//
//        String[] arrChars = text.split("&");
//        List<String > lists = new ArrayList<>(Arrays.asList(arrChars));
//        text.chars()
//                .mapToObj(ch -> Character.toString((char) ch))
//                .filter()
//                .filter(ch -> !lists.contains(ch))
//                .forEach(lists::add);
//
//
//    }
//}
//
//
//
