package org.example.streams;

import java.util.Optional;

public class Optionals {
    void main() {
        String[] s = new String[10];
        s[5] = "my name is Lawrence";
        Optional<String> value = Optional.ofNullable(s[5]);
        System.out.println("filtered value " + value.filter((z)-> z.equals("ABC")));
        System.out.println("CHECK Equals "+ value.filter((d) -> d.equals("my name is Lawrence")));
        System.out.println(value.get());
        System.out.println(value.orElse("not present!"));



    }


}

