package com.epam.web.service;

import com.epam.web.entities.User;

import java.util.Optional;

public class UserService {


    public Optional<User> login(String username, String login) {
        return "admin".equals(username) && "admin".equals(login) ? Optional.of(new User("Svetlana")) : Optional.empty();
    }

}
