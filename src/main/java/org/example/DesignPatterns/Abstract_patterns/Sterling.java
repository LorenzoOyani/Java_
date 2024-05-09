package org.example.DesignPatterns.Abstract_patterns;

public class Sterling implements Bank{

    String bankName = "sterling Bank";
    @Override
    public String getBankName() {
        return bankName;
    }
}
