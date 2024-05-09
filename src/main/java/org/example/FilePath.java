package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FilePath {
    public String[] filePathSeparator(String path) {
        char ps = File.pathSeparatorChar;
        return path.split(String.valueOf(ps));
    }

    public void manipulateArrays() {
        int[] intArrays = new int[3];

        int i = 0;
        for (Integer a : intArrays) {
            int b = a + 3;
            System.out.println(STR."enumerated arrays:  \{i}:\{b}");

        }
        for (int j = 0; j < intArrays.length - 1; j++) {
            intArrays[j] = intArrays[j + 1];

            j = j - 1;

        }
        int[] nums = new int[]{2, 4, 5, 6, 7, 8};

        // Map method of streams.
        List<Integer> numbers = Arrays.asList(3, 4, 5, 6, 7);
        List<Integer> formatted = numbers.stream().map(s -> s * 3).distinct().toList();
        System.out.println(formatted);

        // filter method of streams
        List<String> characters = Arrays.asList("ray", "joe", "country");
        long characterCount = characters.stream().filter(s -> s.isEmpty()).count();

        // limit method
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);


    }

    public int getMin(List<Integer> numbers) {
        int min = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            Integer num = numbers.get(i);
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public int getSum(List<Integer> num) {
        int sum = num.get(0);

        for (int i = 0; i < num.size(); i++) {
            sum += num.get(i);
        }
        return sum;


    }

    public List<Integer> returnSquares(List<Integer> num) {
        List<Integer> squareList = new ArrayList<>();
        for (Integer number : num) {
            int numberInLists = number;

            if (!squareList.contains(numberInLists)) {
                squareList.add(numberInLists);
            }
        }
        return squareList;


    }
}