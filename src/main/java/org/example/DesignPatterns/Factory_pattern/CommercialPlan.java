package org.example.DesignPatterns.Factory_pattern;

public class CommercialPlan extends Plan{
    @Override
    void getRate() {
        rate = 20.00;
    }
}
