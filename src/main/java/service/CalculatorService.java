package service;

import storage.InMemoryCalculatorHistory;

import java.time.LocalDateTime;

public class CalculatorService {
    private LocalDateTime dateAdded = LocalDateTime.now();
    private InMemoryCalculatorHistory calculatorHistory = new InMemoryCalculatorHistory();

    public String getResultAction(String value1, String value2, String operation, String login) {
        String result = "";
        double doubleValue1 = Double.parseDouble(value1);
        double doubleValue2 = Double.parseDouble(value2);

        if (operation.equals("sum")) {
            result = Double.toString(doubleValue1 + doubleValue2);
//            calculatorHistory.addElementHistory(result + " " + dateAdded);
            calculatorHistory.addElementHistory1(login, result + " " + dateAdded);
            return value1 + " " + operation + " " + value2 + " = " + Double.toString(doubleValue1 + doubleValue2);

        } else if (operation.equals("dif")) {
            result = Double.toString(doubleValue1 - doubleValue2);
//            calculatorHistory.addElementHistory(result + " " + dateAdded);
            calculatorHistory.addElementHistory1(login, result + " " + dateAdded);
            return value1 + " " + operation + " " + value2 + " = " + Double.toString(doubleValue1 - doubleValue2);

        } else if (operation.equals("mult")) {
            result = Double.toString(doubleValue1 * doubleValue2);
//            calculatorHistory.addElementHistory(result + " " + dateAdded);
            calculatorHistory.addElementHistory1(login, result + " " + dateAdded);
            return value1 + " " + operation + " " + value2 + " = " + Double.toString(doubleValue1 * doubleValue2);

        } else if (operation.equals("div")) {
            if (doubleValue2 == 0) {
                return "Divide by zero error encountered";
            } else {
                result = Double.toString(doubleValue1 / doubleValue2);
//                calculatorHistory.addElementHistory(result + " " + dateAdded);
                calculatorHistory.addElementHistory1(login, result + " " + dateAdded);
                return value1 + " " + operation + " " + value2 + " = " + Double.toString(doubleValue1 / doubleValue2);
            }
        }
        return "Error";
    }

    public void deleteHistory(String login) {
        calculatorHistory.deleteHistory(login);
    }

}
