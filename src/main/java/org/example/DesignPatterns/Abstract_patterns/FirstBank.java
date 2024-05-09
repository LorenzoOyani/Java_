package org.example.DesignPatterns.Abstract_patterns;

public class FirstBank implements Bank {
    String bankName = "First Bank";

//    FirstBank(String firstBank) {
//        this.bankName = firstBank;
//    }

    @Override
    public String getBankName() {
        return bankName;
    }
}
