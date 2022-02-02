package history;

import java.util.ArrayList;
import java.util.HashMap;

public class HistoryCalculatorInMemory {
//    public static ArrayList<String> historyCalculator = new ArrayList<>();
    public static HashMap<String, String> historyCalculator1 = new HashMap<>();

    public void addElementHistory1(String login, String result){
        if (historyCalculator1.containsKey(login)){
            String oldHistory = historyCalculator1.get(login);
            String newHistory = oldHistory + result + "<br>";
            historyCalculator1.put(login, newHistory);
        } else {
            historyCalculator1.put(login, result);
        }
    }

//    public void addElementHistory(String result) {
//        historyCalculator.add(result);
//    }

//    public String printHistory() {
//        String result = "";
//        if (historyCalculator.size() == 0) {
//            return "History is empty";
//        } else {
//            for (String item : historyCalculator) {
//                result += "Result = " + item + "<br>";
//            }
//        }
//        return result;
//    }

    public String printHistory(String login) {
        if (historyCalculator1.containsKey(login)){
            return historyCalculator1.get(login);
        }
        return "History is empty";
    }





}
