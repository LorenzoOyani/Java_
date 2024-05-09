package org.example.DesignPatterns.Abstract_patterns;

public class HomeLoan extends Loan {
    @Override
    public void getInterestRate(double rates) {
        rate = rates;
    }
}
