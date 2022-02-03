package history;

public interface CalculatorHistory {
    void addElementHistory1(String login, String result);
    String printHistory(String login);
    void deleteHistory(String login);

}
