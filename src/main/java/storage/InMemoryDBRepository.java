package storage;

import entity.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InMemoryDBRepository implements CalculatorHistory, UserStorage{
    private String url = "jdbc:mysql://localhost:3306/calculator?useUnicode=true&serverTimezone=UTC";
    private String username = "root";
    private String password = "admin";

    @Override
    public void addElementHistory1(String login, String result) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO history (result, login_user)" +
                                "VALUES (?, ?)");
                preparedStatement.setString(1, result);
                preparedStatement.setString(2, login);
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> printHistory(String login) {
        List<String> stringList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT result FROM history WHERE login_user = ?");
                preparedStatement.setString(1, login);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                   stringList.add(resultSet.getString(1));
                }

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return stringList;
    }

    @Override
    public void deleteHistory(String login) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "DELETE FROM history WHERE login_user = ?");
                preparedStatement.setString(1, login);
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUser(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO users (name_user, login_user, password_user)" +
                                "VALUES (?, ?, ?)");
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getLogin());
                preparedStatement.setString(3, user.getPassword());
                preparedStatement.execute();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(String login) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT name_user, login_user, password_user\n"+
                                "FROM users WHERE login_user = ?");
                preparedStatement.setString(1, login);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return new User(resultSet.getString("name_user"),
                            resultSet.getString("login_user"),
                            resultSet.getString("password_user"));
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public int getIdUser(String login) {
//        int idUser = -1;
//        try {
//            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
//            try (Connection connection = DriverManager.getConnection(url, username, password)) {
//                PreparedStatement preparedStatement = connection.prepareStatement(
//                        "SELECT * FROM users");
//                ResultSet resultSet = preparedStatement.executeQuery();
//                while (resultSet.next()) {
//                    idUser = resultSet.getInt(1);
//                }
//            }
//        } catch (SQLException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//        return idUser;
//    }
}
