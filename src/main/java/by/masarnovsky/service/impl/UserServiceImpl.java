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
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
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

    public void removeUser(int id) {
        userDAO.removeUser(id);
    }
}
