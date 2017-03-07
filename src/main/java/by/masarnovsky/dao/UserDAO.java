package by.masarnovsky.dao;

import by.masarnovsky.model.User;

import java.util.List;

public interface UserDAO {
    void addUser(User user);
    void updateUser(User user);
    List<User> listUsers();
    User getUserById(int id);
    void removeUser(int id);
}
