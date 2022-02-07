package service;

import entity.User;
import storage.DBRepository;
import storage.InMemoryUserStorage;

public class UserService {
    private InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();
    private DBRepository dbRepository = new DBRepository();

    public User getUser(String login) {
        return inMemoryUserStorage.getUser(login);
    }
    // Optional<User>

    public boolean isCheckUser(User user){
        if (user == null){
            return false;
        }
        return true;
    }



}
