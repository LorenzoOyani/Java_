package org.example.DesignPatterns.Abstract_patterns;

public class ZenithBank implements Bank {
    String bankName = "Zenith Bank";

    @Override
    public String getBankName() {
        return bankName;
    }
}
