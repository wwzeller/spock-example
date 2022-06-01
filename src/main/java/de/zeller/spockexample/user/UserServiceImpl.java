package de.zeller.spockexample.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final List<User> users = new ArrayList<>();

    @Override
    public void createUser(String name) {
        users.add(new User(users.size() + 1, name, null));
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users);
    }
}
