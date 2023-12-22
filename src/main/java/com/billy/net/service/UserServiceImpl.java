package com.billy.net.service;

import com.billy.net.dao.UserDAO;
import com.billy.net.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(int id, User updatedUser) {
        // Получить существующего пользователя
        User existingUser = userDAO.getUserById(id);

        // Проверить, существует ли пользователь с данным id
        if (existingUser != null) {
            // Обновить данные пользователя
            existingUser.setName(updatedUser.getName());
            existingUser.setSurname(updatedUser.getSurname());
            existingUser.setDepartment(updatedUser.getDepartment());
            existingUser.setSalary(updatedUser.getSalary());
            // Обновить другие поля, если они есть

            // Вызвать метод updateUser из DAO с обновленным пользователем
            userDAO.updateUser(existingUser);
        } else {
            // Обработать сценарий, когда пользователя с данным id не существует
            // Можно выбросить исключение или сделать что-то другое
        }
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
