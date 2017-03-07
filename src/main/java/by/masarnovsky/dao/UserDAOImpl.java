package by.masarnovsky.dao;

import by.masarnovsky.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//@Repository
public class UserDAOImpl implements UserDAO {
    private JdbcTemplate jdbcTemplate;

    private final String ADD_NEW_USER = "insert into users(fio, email, login, password, role) values (?, ?, ?, ?, ?)";

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUser(User user) {
        jdbcTemplate.update(ADD_NEW_USER, "test1", "test1", "test1", "test1", "user");
    }

    public void updateUser(User user) {

    }

    public List<User> listUsers() {
        return jdbcTemplate.query("select * from users", new UserRowMapper());
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

class UserRowMapper implements RowMapper<User> {

    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        User user = new User(resultSet.getInt("id"),
                resultSet.getString("fio"),
                resultSet.getString("email"),
                resultSet.getString("login"),
                resultSet.getString("password"),
                resultSet.getString("role"));
        return user;
    }
}