package com.reactive.servie;

import com.reactive.entity.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    Map<String, User> users = new HashMap<>();
    UserService() {
        users.put("1", new User("1", "Rajasekhar"));
        users.put("2", new User("2", "Raja"));
    }

    public User getUser(String id) {
        return users.get(id);
    }

    public Collection<User> getAllUsers() {
        return users.values();
    }

    public User updateUser(User user) {
        return users.put(user.getUserid(), user);
    }

}
