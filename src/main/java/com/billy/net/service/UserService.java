package com.billy.net.service;

import com.billy.net.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(int id);

    void addUser(User user);

    void updateUser(int id, User updatedUser);

    void deleteUser(int id);
}
