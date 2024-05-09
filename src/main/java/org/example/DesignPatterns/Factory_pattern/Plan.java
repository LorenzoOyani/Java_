package org.example.DesignPatterns.Factory_pattern;

/*
 * This pattern tells you to define an interface or an Abstract class to create an Object,
 * but let its sub-class to decide which class to instantiate
 *
 * It promotes loose-coupling
 * */
public abstract class Plan {
    protected double rate;

    abstract void getRate();

    public void calculateBill(int billsUnit) {
        System.out.println(billsUnit * rate);
    }
}
