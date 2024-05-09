package org.example.DesignPatterns.Factory_pattern;

public class GetFactoryPlan {
    public  Plan getPlan(String planType) {
        if (planType == null) {
            return null;
        }
        if (planType.equalsIgnoreCase("domesticPlan")) {
            return new DomesticPlan();
        }
        if (planType.equalsIgnoreCase("commercialPlan")) {
            return new CommercialPlan();
        }
        if (planType.equalsIgnoreCase("institutionalPlan")) {
            return new InstitutionalPlan();
        }
        return null;

    }
}
