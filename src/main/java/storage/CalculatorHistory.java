package storage;

import java.util.List;

public interface CalculatorHistory {
    void addElementHistory1(String login, String result);
    List<String> printHistory(String login);
    void deleteHistory(String login);
}
