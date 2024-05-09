package org.example.Count;

public class newCount {

        private final String name;
        private int count;
        public newCount(String id)
        { name = id; }
        public void increment()
        { count++; }
        public int tally()
        { return count; }
        public String toString()
        { return count + " " + name; }
        public static void main(String[] args)
        {
            newCount heads = new newCount("heads");
            newCount tails = new newCount("tails");
            heads.increment();
            heads.increment();
            tails.increment();
            System.out.println(heads + " " + tails);
            System.out.println(heads.tally() + tails.tally() );
        }
    }

