package org.example.DesignPatterns.Abstract_patterns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AbstractFactoryMain {
    void main() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter the name of bank you want to get a loan from: ");
            String bankName = reader.readLine();

            double rates = Double.parseDouble(reader.readLine());
            System.out.println("\n");
            System.out.println("Enter the loan amount: ");
            System.out.println("\n");
            double loanAmount = Double.parseDouble(reader.readLine());
            System.out.println("\n");
            System.out.println("Enter the years: ");
            int years = Integer.parseInt(reader.readLine());
            System.out.println();
            String loanName = reader.readLine();

            AbstractFactory factory = FactoryCreatorClass.getFactoryClass("Bank");
            assert factory != null;
            Bank bank = factory.getBank(bankName);

            System.out.println(STR."Enter interest rate of \{bank.getBankName()}");
            AbstractFactory factory1 = FactoryCreatorClass.getFactoryClass("Loan");
            assert factory1 != null;
            Loan loan = factory1.getLoan(loanName);
            loan.getInterestRate(rates);
            loan.calculateLoanPayment(loanAmount, years);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
