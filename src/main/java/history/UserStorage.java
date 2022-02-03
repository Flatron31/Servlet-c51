package history;

import entity.User;

public interface UserStorage {
    void addUser(User user);
    User getUser(String login);
}
