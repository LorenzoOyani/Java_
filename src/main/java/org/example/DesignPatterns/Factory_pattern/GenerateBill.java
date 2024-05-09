package org.example.DesignPatterns.Factory_pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GenerateBill {
    void main() {
        GetFactoryPlan getFactoryPlan = new GetFactoryPlan();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Enter a plan name of bill to generate bill for that specific plan");
            String planName = reader.readLine();
            System.out.println("Enter the unit ");
            int unit = Integer.parseInt(reader.readLine());
            Plan plan = getFactoryPlan.getPlan(planName);
            System.out.println(STR."The billRate of \{planName}an of units \{unit} is :");
//            double rate = plan.rate;
            plan.getRate();
            plan.calculateBill(unit);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
