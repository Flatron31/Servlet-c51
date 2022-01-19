package service;

import validation.Validation;

public class CalculatorService {
    private String value1 = "";
    private String value2 = "";
    private String action = "";
    private Validation validation = new Validation();

    public CalculatorService() {
    }

    public String getResultAction(String value1, String value2, String action){
        double doubleValue1 = Double.parseDouble(value1);
        double doubleValue2 = Double.parseDouble(value2);

        if (validation.isNull(value1, value2, action)){
            return "Value is null";
        }
        if (!(validation.isNumber(value1) & validation.isNumber(value2))){
            return "NaN";
        }

        if (action.equals("sum")){
            return Double.toString(doubleValue1 + doubleValue2);
        }
        else if (action.equals("dif")){
            return Double.toString(doubleValue1 - doubleValue2);
        }
        else if (action.equals("mult")){
            return Double.toString(doubleValue1 * doubleValue2);
        }
        else if (action.equals("div")){
            return Double.toString(doubleValue1 / doubleValue2);
        }
        return "Error";
    }
}
