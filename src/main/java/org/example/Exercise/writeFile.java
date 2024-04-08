package org.example.Exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class writeFile {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            System.out.println("usage: java file");
            System.exit(1);
        }

        File file = new File(args[0]);
        if (!file.isFile()) {
            System.out.println("The file " + args[0] + " does not exist");
            System.exit(2);
        }

        Set<String> treeSet = new TreeSet<>();

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                String[] line = sc.nextLine().split(",,/");
                for (String lines : line) {
                    if (lines.isEmpty()) {
                        treeSet.add(lines);
                    }
                }
            }
        }
        System.out.println(treeSet);

    }
}