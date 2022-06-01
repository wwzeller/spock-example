package de.zeller.spockexample.user;

import java.util.List;

public interface UserService {
    void createUser(String name);
    List<User> getAll();
}
