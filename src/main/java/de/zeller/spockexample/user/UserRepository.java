package de.zeller.spockexample.user;

import de.zeller.spockexample.ResourceNotFoundException;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public void createUser(String name) {
        users.add(new User(users.size() + 1, name, null, OffsetDateTime.now()));
    }

    public void updateName(int userId, String newName) {
        users.stream()
                .filter(user -> user.getId() == userId)
                .findFirst()
                .ifPresentOrElse(user -> {
                    user.setName(newName);
                    user.setUpdatetAt(OffsetDateTime.now());
                }, ResourceNotFoundException::new);
    }

    public List<User> getAll() {
        return new ArrayList<>(users);
    }
}
