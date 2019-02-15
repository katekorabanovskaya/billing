package com.netcracker.edu.backend.service;


import com.netcracker.edu.backend.entity.User;

import java.util.Optional;

public interface UserService {

    Iterable<User> getAllUsers();

    Optional<User> getUser(Long id);

    Optional<User> getUserByLogin(String login);

    User saveUser(User user);

    void deleteUser(Long id);

}
