package service;

import history.InMemoryCalculatorHistory;
import validation.Validation;

import java.time.LocalDateTime;

public class CalculatorService {
    private LocalDateTime dateAdded = LocalDateTime.now();
    private InMemoryCalculatorHistory calculatorHistory = new InMemoryCalculatorHistory();
    private Validation validation = new Validation();

    public String getResultAction(String value1, String value2, String operation, String login) {
        String result = "";
        double doubleValue1 = Double.parseDouble(value1);
        double doubleValue2 = Double.parseDouble(value2);

        if (operation.equals("sum")) {
            result = Double.toString(doubleValue1 + doubleValue2);
//            calculatorHistory.addElementHistory(result + " " + dateAdded);
            calculatorHistory.addElementHistory1(login, result);
            return value1 + " " + operation + " " + value2 + " = " + Double.toString(doubleValue1 + doubleValue2);

        } else if (operation.equals("dif")) {
            result = Double.toString(doubleValue1 - doubleValue2);
//            calculatorHistory.addElementHistory(result + " " + dateAdded);
            calculatorHistory.addElementHistory1(login, result);
            return value1 + " " + operation + " " + value2 + " = " + Double.toString(doubleValue1 - doubleValue2);

        } else if (operation.equals("mult")) {
            result = Double.toString(doubleValue1 * doubleValue2);
//            calculatorHistory.addElementHistory(result + " " + dateAdded);
            calculatorHistory.addElementHistory1(login, result);
            return value1 + " " + operation + " " + value2 + " = " + Double.toString(doubleValue1 * doubleValue2);

        } else if (operation.equals("div")) {
            if (doubleValue2 == 0) {
                return "Divide by zero error encountered";
            } else {
                result = Double.toString(doubleValue1 / doubleValue2);
//                calculatorHistory.addElementHistory(result + " " + dateAdded);
                calculatorHistory.addElementHistory1(login, result);
                return value1 + " " + operation + " " + value2 + " = " + Double.toString(doubleValue1 / doubleValue2);
            }
        }
        return "Error";
    }
}
