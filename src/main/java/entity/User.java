package entity;

public class User {
    private String login;
    private String name;
    private String password;
    private String authorizationSessionID;

    public User() {
    }

    public User(String login, String name, String password, String authorizationSessionID) {
        this.login = login;
        this.name = name;
        this.password = password;
        this.authorizationSessionID = authorizationSessionID;
    }

    public void setAuthorizationSessionID(String authorizationSessionID) {
        this.authorizationSessionID = authorizationSessionID;
    }

    public User(String login, String name, String password) {
        this.login = login;
        this.name = name;
        this.password = password;
    }

    public String getAuthorizationSessionID() {
        return authorizationSessionID;
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
