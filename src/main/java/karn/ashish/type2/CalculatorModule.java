package karn.ashish.type2;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.Singleton;

public class CalculatorModule extends AbstractModule {

    @Override
    protected void configure() {
        //bind(Calculator.class).to(CalculatorImpl.class);
//        bind(Calculator.class).to(CalculatorImpl.class).in(Singleton.class);
        bind(Calculator.class).to(CalculatorImpl.class).in(Scopes.SINGLETON);

    }
}
