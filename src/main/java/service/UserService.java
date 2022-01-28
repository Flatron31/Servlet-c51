package service;

import entity.User;
import history.UserStorage;

public class UserService {
    private UserStorage inMemoryUserStorage = new UserStorage();

    public User getUser(String login) {
        return inMemoryUserStorage.getUser(login);
    }

    public boolean isCheckUser(User user){
        if (user == null){
            return false;
        }
        return true;
    }

}
