package by.masarnovsky.service.impl;

import by.masarnovsky.dao.UserDAO;
import by.masarnovsky.model.User;
import by.masarnovsky.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //@Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    public void update(User user) {
        userDAO.update(user);
    }

    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    public List<User> getUserByLogin(String login) {
        return userDAO.getUserByLogin(login);
    }

    public void delete(int id) {
        userDAO.delete(id);
    }

    @Override
    public boolean isAdmin(User user) {
        return userDAO.isAdmin(user);
    }

    @Override
    public int getUsersCount() {
        return userDAO.getUsersCount();
    }
}
