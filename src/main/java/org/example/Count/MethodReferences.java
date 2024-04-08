package org.example.Count;

import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MethodReferences {
    void main(){
        SecureRandom secureRandom = new SecureRandom();
        String numbers =secureRandom.ints(10, 1,7)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
        System.out.printf("%n random numbers of securedRandom: %s%n ", numbers);

        System.out.println(IntStream.rangeClosed(2, 10)
                .filter(x -> x % 2 == 0)
                .map(x -> x * 2)
                // concatenate objects and join or return as list using collectors.
                .mapToObj(String::valueOf)
                .collect(Collectors.toList()));

        System.out.println(
                IntStream.rangeClosed(3, 21)
                        .map(x ->{
                            if(x % 2 == 0){
                                return x * 3;
                            } else {
                                return 0;
                            }
                        })
                        .reduce(Integer::sum)


        );
        System.out.println(
                System.out.printf("%nThe sum of the integer is: %d%n",
                        IntStream.rangeClosed(30, 100)
                                .map((int x) -> {return  x * 2; })

                        )
        );
    }
//    static  class unknowGenerics{
//        public <E> displayNumbers(E[] numbers){
//            for(E elements : numbers){
//                System.out.println(elements);
//            }
//            System.out.println();
//        }
//        static void main(){
//            int[] values = {2, 4, 5, 6,7};
//            String[] inputs = {"red, lane, batch"};
//            displayNumbers(values);
//        }

//        private static void displayNumbers(int[] values) {
//        }
    }

