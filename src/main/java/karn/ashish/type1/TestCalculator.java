package karn.ashish.type1;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestCalculator {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new CalculatorModule());
        Calculator calculator=injector.getInstance(Calculator.class);
        System.out.println(calculator.add(4,5));
        System.out.println(calculator.sub(14,5));
        System.out.println(calculator.mul(4,5));
        System.out.println(calculator.div(14,5));

    }
}
