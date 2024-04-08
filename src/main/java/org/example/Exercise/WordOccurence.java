package org.example.Exercise;

public class WordOccurence implements Comparable<WordOccurence> {
    String name;
    int count;

    WordOccurence(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public int compareTo(WordOccurence o) {
        return 0;
    }
}

//    }
//
//    @Override
//    public int compareTo(WordOccurence o) {
//        return o.count.compareTo(count);
//    }

//    public String toString() {
//        return name + " " + count;
//    }
//}
