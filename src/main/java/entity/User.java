package entity;

public class User {
    private String login;
    private String password;
    private String name;
    private int idUser;

    public User() {
    }

    public User(String name, String login, String password, int idUser) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.idUser = idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
