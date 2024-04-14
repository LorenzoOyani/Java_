package org.example.Exercise;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;
public class SortedFilesCount {

    public static void crackFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Map<String, Integer> entrySets = new HashMap<>();

        String line;
        while ((line = reader.readLine()) != null) {
            if (!line.isEmpty()) {
                entrySets.put(line, entrySets.getOrDefault(line, 0) +1 );
            }
            }
        reader.close();
        for (Map.Entry<String, Integer> entry : entrySets.entrySet() ) {
            System.out.println(STR."entries \{entry.getKey()} \{entry.getValue()}");
        }
        }

    public static void main() throws IOException {
        Scanner scanner = new Scanner(in);

        scanner.nextLine();
        System.out.println("waiting on an input file: ");
        String keyboardInput;
        do {
            keyboardInput = scanner.nextLine();
            File file = new File(keyboardInput);
            if (file.exists()) {
                crackFile(file);
            }
        } while (!keyboardInput.equalsIgnoreCase("exit"));

    }
    }



