package history;

import entity.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserStorage {
    private static final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }
}
