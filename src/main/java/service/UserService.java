package service;

import entity.User;
import storage.InMemoryDBRepository;
import storage.InMemoryUserStorage;

public class UserService {
    private InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();
    private InMemoryDBRepository dbRepository = new InMemoryDBRepository();

    public boolean isCheckUser(User user) {
        if (user == null) {
            return false;
        }
        return true;
    }

    // изменение под DB в работе------------------
    public User getUserDB(String login) {
        return dbRepository.getUser(login);
    }

    public void addUser(User user) {
        dbRepository.addUser(user);
    }


}
