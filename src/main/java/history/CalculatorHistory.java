package history;

import java.util.ArrayList;

public class CalculatorHistory {
    public static ArrayList<String> historyCalculator = new ArrayList<>();

    public void addElementHistory(String result) {
        historyCalculator.add(result);
    }

    public String printHistory() {
        String result = "";
        if (historyCalculator.size() == 0) {
            return "History is empty";
        } else {
            for (String item : historyCalculator) {
                result += "Result = " + item + "\n";
            }
        }
        return result;
    }

}
