package org.example.DesignPatterns.Abstract_patterns;

public class LoanFactory extends AbstractFactory {
    @Override
    public Bank getBank(String bank) {
        return null;
    }

    @Override
    public Loan getLoan(String loan) {
        if (loan == null) {
            return null;
        }
        if (loan.equalsIgnoreCase("HomeLoan")) {
            return new HomeLoan();
        }
        if (loan.equalsIgnoreCase("BusinessLoan")) {
            return new BusinessLoan();
        }
        if (loan.equalsIgnoreCase("EconomicLoan")) {
            return new EconomicLoan();
        }
        return null;
    }
}
