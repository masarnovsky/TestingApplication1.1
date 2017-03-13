package by.masarnovsky.dao.jdbc;

import by.masarnovsky.dao.UserDAO;
import by.masarnovsky.dao.rowmapper.UserRowMapper;
import by.masarnovsky.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserJdbcDAOImpl implements UserDAO {
    private JdbcTemplate jdbcTemplate;

    private final String SELECT_ALL_USERS = "select id, name, surname, email, login, AES_DECRYPT(login, password) from users";
    private final String ADD_NEW_USER = "insert into users(name, surname, email, login, AES_ENCRYPT(login, password)) values (?, ?, ?, ?, ?)";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUser(User user) {
        jdbcTemplate.update(ADD_NEW_USER, user.getName(), user.getSurname(), user.getEmail(), user.getLogin(), user.getPassword());
    }

    public void updateUser(User user) {
        //
    }

    public List<User> listUsers() {
        return jdbcTemplate.query(SELECT_ALL_USERS, new UserRowMapper());
    }

    public User getUserById(int id) {
        return null;
    }

    public void removeUser(int id) {

    }


//    private SessionFactory sessionFactory;
//
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    public void addUser(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        session.persist(user);
//    }
//
//    public void updateUser(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        session.update(user);
//    }
//
//    public List<User> listUsers() {
//        Session session = sessionFactory.getCurrentSession();
//        List<User> userList = session.createQuery("from users").list();
//        return userList;
//    }
//
//    public User getUserById(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        User u = (User) session.load(User.class, new Integer(id));
//        return u;
//    }
//
//    public void removeUser(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        User u = (User) session.load(User.class, new Integer(id));
//        if (u != null){
//            session.delete(u);
//        }
//    }
}

