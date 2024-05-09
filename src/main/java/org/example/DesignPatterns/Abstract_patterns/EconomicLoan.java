package org.example.DesignPatterns.Abstract_patterns;

public class EconomicLoan extends Loan{
    @Override
    public void getInterestRate(double rates) {
        rate = rates;
    }
}
