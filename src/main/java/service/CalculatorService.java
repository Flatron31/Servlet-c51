package service;

import history.CalculatorHistory;
import validation.Validation;

import java.time.LocalDateTime;

public class CalculatorService {
    private LocalDateTime dateAdded = LocalDateTime.now();
    private CalculatorHistory calculatorHistory = new CalculatorHistory();
    private Validation validation = new Validation();

    public String getResultAction(String value1, String value2, String action) {
        String result = "";
        double doubleValue1 = Double.parseDouble(value1);
        double doubleValue2 = Double.parseDouble(value2);

        if (action.equals("sum")) {
            result = Double.toString(doubleValue1 + doubleValue2);
            calculatorHistory.addElementHistory(result + " " + dateAdded);
            return value1 + " " + action + " " + value2 + " = " + Double.toString(doubleValue1 + doubleValue2);
        } else if (action.equals("dif")) {
            result = Double.toString(doubleValue1 - doubleValue2);
            calculatorHistory.addElementHistory(result + " " + dateAdded);
            return value1 + " " + action + " " + value2 + " = " + Double.toString(doubleValue1 - doubleValue2);
        } else if (action.equals("mult")) {
            result = Double.toString(doubleValue1 * doubleValue2);
            calculatorHistory.addElementHistory(result + " " + dateAdded);
            return value1 + " " + action + " " + value2 + " = " + Double.toString(doubleValue1 * doubleValue2);
        } else if (action.equals("div")) {
            if (doubleValue2 == 0) {
                return "Divide by zero error encountered";
            } else {
                result = Double.toString(doubleValue1 / doubleValue2);
                calculatorHistory.addElementHistory(result + " " + dateAdded);
                return value1 + " " + action + " " + value2 + " = " + Double.toString(doubleValue1 / doubleValue2);
            }
        }
        return "Error";
    }
}
