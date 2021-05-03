package karn.ashish.type2;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestCalculator {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new CalculatorModule());
        Calculator calculator=injector.getInstance(Calculator.class);
        System.out.println(calculator);
        System.out.println(calculator.add(4,5));
        System.out.println(calculator.sub(14,5));
        System.out.println(calculator.mul(4,5));
        System.out.println(calculator.div(14,5));

        //to check singleton or prototype..configured in Calculator Module
        Calculator calculator2=injector.getInstance(Calculator.class);
        System.out.println(calculator2);


    }
}
