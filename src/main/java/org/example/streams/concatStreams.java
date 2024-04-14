package org.example.streams;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class concatStreams {
    void main() {
        String[] list = new String[]{"java", "is", "fun", "!"};
        StringBuilder sb = new StringBuilder();

        String result = String.join(" ", list);
        sb.append(result);
        System.out.println("The concatenated string :" +sb.toString() );

    }
}
