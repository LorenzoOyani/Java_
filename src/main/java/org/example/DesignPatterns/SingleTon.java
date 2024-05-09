package org.example.DesignPatterns;

public class SingleTon {
    static SingleTon singleTon = new SingleTon();

    SingleTon(){}; // an instance for Object creation.

    public static SingleTon getInstance() { // this method creates a single accessible object from this class
        return singleTon;
    }

    public void getMethod() {
        System.out.println("The method gotten from a singleton class");
    }
    void main() {
        SingleTon tmp = SingleTon.getInstance();
        tmp.getMethod();

    }


}

