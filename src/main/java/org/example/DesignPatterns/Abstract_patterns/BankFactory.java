package org.example.DesignPatterns.Abstract_patterns;

public class BankFactory extends AbstractFactory {
    @Override
    public Bank getBank(String bank) {
        if (bank == null) {
            return null;
        }
        if (bank.equalsIgnoreCase("FirstBank")) {
            return new FirstBank();
        }
        if (bank.equalsIgnoreCase("sterling")) {
            return new Sterling();

        }
        if (bank.equalsIgnoreCase("zenithBank")) {
            return new ZenithBank();
        }
        return null;
    }

    @Override
    public Loan getLoan(String loan) {
        return null;
    }
}
