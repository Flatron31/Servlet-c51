package service;

import storage.InMemoryDBRepository;

import java.util.List;

public class CalculatorService {
    private InMemoryDBRepository dbRepository = new InMemoryDBRepository();

    public String getResultOperation(String value1, String value2, String operation, String login) {
        String resultOperationCalculator = getResultOperationCalculator(value1, value2, operation);
        String result = value1 + " " + operation + " " + value2 + " = " + resultOperationCalculator;
        dbRepository.addElementHistory1(login, resultOperationCalculator);
        return result;
    }

    public String getResultOperationCalculator(String value1, String value2, String operation) {
        String result = "";
        double doubleValue1 = Double.parseDouble(value1);
        double doubleValue2 = Double.parseDouble(value2);
        if (operation.equals("sum")) {
            result = Double.toString(doubleValue1 + doubleValue2);
            return result;
        } else if (operation.equals("dif")) {
            result = Double.toString(doubleValue1 - doubleValue2);
            return result;
        } else if (operation.equals("mult")) {
            result = Double.toString(doubleValue1 * doubleValue2);
            return result;
        } else if (operation.equals("div")) {
            if (doubleValue2 == 0) {
                return "Divide by zero error encountered";
            } else {
                result = Double.toString(doubleValue1 / doubleValue2);
                return result;
            }
        }
        return "Error";
    }

    public void deleteHistory(String login) {
        dbRepository.deleteHistory(login);
    }

    public List<String> printHistory(String login) {
        return dbRepository.printHistory(login);
    }
}
