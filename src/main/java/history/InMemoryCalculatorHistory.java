package history;

import java.util.HashMap;

public class InMemoryCalculatorHistory {
//    public static ArrayList<String> historyCalculator = new ArrayList<>();
    public static HashMap<String, String> calculatorHistory = new HashMap<>();

    public void addElementHistory1(String login, String result){
        if (calculatorHistory.containsKey(login)){
            String oldHistory = calculatorHistory.get(login);
            String newHistory = oldHistory + result + "<br>";
            calculatorHistory.put(login, newHistory);
        } else {
            calculatorHistory.put(login, result);
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
        if (calculatorHistory.containsKey(login)){
            return calculatorHistory.get(login);
        }
        return "History is empty";
    }

    public void deleteHistory(String login){
        calculatorHistory.remove(login);
    }





}
