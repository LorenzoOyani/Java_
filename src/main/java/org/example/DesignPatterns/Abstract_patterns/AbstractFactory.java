package org.example.DesignPatterns.Abstract_patterns;

public abstract class AbstractFactory {
    public abstract Bank getBank(String bank);
    public abstract Loan getLoan(String loan);
}
