package service;

import entity.User;
import history.UserStorageInMemory;

public class UserService {
    private UserStorageInMemory inMemoryUserStorage = new UserStorageInMemory();

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
