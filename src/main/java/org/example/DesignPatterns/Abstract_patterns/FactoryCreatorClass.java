package org.example.DesignPatterns.Abstract_patterns;

public class FactoryCreatorClass {
    public static AbstractFactory getFactoryClass(String factoryChoice) {
        if (factoryChoice.equalsIgnoreCase("Bank")) {
            return new BankFactory();
        }
        if (factoryChoice.equalsIgnoreCase("Loan")) {
            return new LoanFactory();
        }
        return null;
    }
}
