package org.example.DesignPatterns.Abstract_patterns;

public abstract class Loan {

    protected double rate;

    public abstract void getInterestRate(double rate);

    public void calculateLoanPayment(double loanAmount, int years) {
        /*
         * rate = Annual interest rate /years *12
         * 1 year =12 months;
         * n = years * 12;
         *
         * */
        double EMI;
        int n;
        n = years * 12;
        rate = rate / 1200;

        EMI = ((rate * Math.pow((1 + rate), n)) / ((Math.pow((1 + rate), n)) - 1)) * loanAmount;
        System.out.println(STR."Your monthly \{EMI} for the amount \{loanAmount}You have borrowed");
    }

}
