package karn.ashish.type3;

import javax.inject.Inject;

public class CalculatorService {
    @Inject
    private Calculator calculator;

    public double calculate(double a,double b, String oper){
        if(oper.equals("add")){
            return calculator.add(a,b);
        }
        if(oper.equals("sub")){
            return calculator.sub(a,b);
        }
        if(oper.equals("mul")){
            return calculator.mul(a,b);
        }
        if(oper.equals("div")){
            return calculator.div(a,b);
        }
        return 0;
    }
}
