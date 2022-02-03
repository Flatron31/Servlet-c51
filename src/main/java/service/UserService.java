package service;

import entity.User;
import storage.InMemoryUserStorage;

public class UserService {
    private InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    public User getUser(String login) {
        return inMemoryUserStorage.getUser(login);
    }
    //public Optional<User>

    public boolean isCheckUser(User user){
        if (user == null){
            return false;
        }
        return true;
    }

}
