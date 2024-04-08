//package org.example.Exercise;//package org.example;

import java.util.Scanner;//un-named classes;
void main() {
    Randoms randoms;
    for (Randoms random: Randoms.values()) {
        System.out.println(random);
    }
    System.out.println("dry ordinal values: "+ Randoms.valueOf("wind").ordinal());
}

 enum Randoms {
    winter(50),
    rain(75),
    dry(90),
    wind(43);

    int value;
    private Randoms(int value){
        this.value  = value;
    }

}

