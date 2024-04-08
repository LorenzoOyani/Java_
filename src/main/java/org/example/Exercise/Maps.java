package org.example.Exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * A map is a container Object that stores a collections of key/value pairs
 * ity enables fast deletions, updating, retrieval of the pair through its key.
 * The keys are like indexes. in List the keys are Integers, while in Maps keys can be any Objects
 * A map can contain duplicates keys, each key maps to one value
 * The three type of concrete classes of Maps : HasMap, LinkedHashMap, TreeMap.
 * The Map interface implements the sortedMap, and navigableMap Interfaces.
 * The map Interfaces also extends that Abstract Map class
 */
public class Maps {
//    public static void main(String[] args) {
//        Map<String, Integer> hashmap = new HashMap<>();
//        hashmap.put("Lawrence", 28);
//        hashmap.put("michael", 24);
//        hashmap.put("Jane", 22);
//        System.out.println("Display entries in sets\n");
//        System.out.println(hashmap); // output un-ordered
//
//        Map<String, Integer> treeMap = new TreeMap<>(hashmap);
//        System.out.println("Display entries in sets\n");
//        System.out.println(treeMap); // output in sorted order
//
//        Map<String, Integer> linkedhash = new LinkedHashMap<>(100, 0.75f, true);
////        Map<String, Integer> hashs = new HashMap<>(100, 0.75f);
//        linkedhash.put("monica", 45);
//        linkedhash.put("andrew", 43);
//        linkedhash.put("lauren", 13);
//        System.out.println("Display entries in sets\n");
//        System.out.println(linkedhash);
//



    static class Test {
        public static void main(String[] args) {
            Map<String, String> map = new LinkedHashMap<>();
            map.put("123", "John Smith");
            map.put("111", "George Smith");
            map.put("444", "Steve Yao");
            map.put("222", "Steve Yao");
            System.out.println("(1) " + map);
            System.out.println("(2) " + new TreeMap<String, String>(map));
        }
    }

    }

