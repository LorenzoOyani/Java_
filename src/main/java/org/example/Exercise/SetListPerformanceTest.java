package org.example.Exercise;

import java.util.*;

public class SetListPerformanceTest {

    private static final int N = 5000;
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            list.add(i);
        }
        Collections.shuffle(list);

        Collection<Integer> set1 = new HashSet<>(list);
        System.out.println("Member test time for HashSet is "+ getTestTime(set1) + " milliseconds" );
        System.out.println("Remove test-time for HashSets "+ RemoveTestTime(set1) + "milliseconds");

        Collection<Integer> set2 = new TreeSet<>(list);
        System.out.println("Member test time for TreeSet is "+ getTestTime(set2) + " milliseconds" );
        System.out.println("Remove test-time for TreeSet "+ RemoveTestTime(set2) + " milliseconds");

        Collection<Integer> set3 = new LinkedHashSet<>(list);
        System.out.println("Member test time for LinkedHashSet is "+ getTestTime(set3) + " milliseconds" );
        System.out.println("Remove test-time for LinkedHashSets "+ RemoveTestTime(set3) + " milliseconds");

        Collection<Integer> set4 = new LinkedList<>(list);
        System.out.println("Member test time for LinkedList is "+ getTestTime(set4) + " milliseconds" );
        System.out.println("Remove test-time for LinkedList "+ RemoveTestTime(set4) + " milliseconds");
    }


    public static long getTestTime(Collection<Integer> c){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < N; i++){
            c.contains((int) (Math.random() * 2 * N));

        }

        return System.currentTimeMillis() - startTime;
    }
    public static long RemoveTestTime(Collection<Integer> c){
        long endTime =System.currentTimeMillis();
        for(int i = 0; i < N; i ++){
            c.remove(i);
        }
        return System.currentTimeMillis() - endTime;
    }
}