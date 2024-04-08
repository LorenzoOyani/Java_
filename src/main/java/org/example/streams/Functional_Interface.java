package org.example.streams;

/**
 * Implementation of a functional interface : an interface with one method.
 * */
public class Functional_Interface {
    public interface Drawable{
        void draw();

    }
    public static void main(String[] args){
        int width = 10;

        Drawable drawable = ()->{
            System.out.println(STR."drawing \{width}");
        };
        drawable.draw();
    }


}
class newInterface{
    public interface Sayings{
        public void say();
    }
    public static void main(String[] args){
        Sayings sayings = ()->{

            System.out.println("I love Java"  );
        };
        sayings.say();

    }


}