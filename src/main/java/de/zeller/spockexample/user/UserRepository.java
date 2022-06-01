package de.zeller.spockexample.user;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public void createUser(String name) {
        users.add(new User(users.size() + 1, name, null));
    }

    public List<User> getAll() {
        return new ArrayList<>(users);
    }
}
