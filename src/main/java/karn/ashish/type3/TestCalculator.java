package karn.ashish.type3;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestCalculator {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new CalculatorModule());
        CalculatorService calculatorService=injector.getInstance(CalculatorService.class);
        System.out.println(calculatorService);
        System.out.println(calculatorService.calculate(4,5,"add"));
        System.out.println(calculatorService.calculate(14,5,"sub"));
        System.out.println(calculatorService.calculate(4,5, "mul"));
        System.out.println(calculatorService.calculate(14,5,"div"));

        //to check singleton or prototype..configured in Calculator Module
        CalculatorService calculatorService2=injector.getInstance(CalculatorService.class);
        System.out.println(calculatorService2);


    }
}
