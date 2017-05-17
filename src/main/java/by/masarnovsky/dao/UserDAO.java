package by.masarnovsky.dao;

import by.masarnovsky.model.User;

import java.util.List;

public interface UserDAO {
    void save(User user);
    void update(User user);
    List<User> listUsers();
    User getUserById(int id);
    List<User> getUserByLogin(String login);
    void delete(int id);
    boolean isAdmin(User user);
}
