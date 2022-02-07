package storage;

import entity.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBRepository implements CalculatorHistory, UserStorage{
    private String url = "jdbc:mysql://localhost:3306/todo?useUnicode=true&serverTimezone=UTC";
    private String username = "root";
    private String password = "admin";


    @Override
    public void addElementHistory1(String login, String result) {

    }

    @Override
    public String printHistory(String login) {
        return null;
    }

    @Override
    public void deleteHistory(String login) {

    }

    @Override
    public void addUser(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO users (name_user, login_user, password_user)\n" +
                                "VALUES (?, ?, ?)");
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getLogin());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(String login) {
        return null;
    }
}
