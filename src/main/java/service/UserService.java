package service;

import entity.User;
import history.InMemoryUserStorage;

public class UserService {
    private InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    public User getUser(String login) {
        return inMemoryUserStorage.getUser(login);
    }

}
