package karn.ashish.type1;

import com.google.inject.AbstractModule;

public class CalculatorModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Calculator.class);
    }
}
