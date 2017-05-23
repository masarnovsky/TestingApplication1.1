package by.masarnovsky.dao.jdbc;

import by.masarnovsky.dao.UserDAO;
import by.masarnovsky.dao.rowmapper.UserRowMapper;
import by.masarnovsky.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOJdbcImpl implements UserDAO {
    private JdbcTemplate jdbcTemplate;

    private final String SELECT_ALL_USERS = "select * from users";
    private final String ADD_NEW_USER = "insert into users(name, surname, email, login, password) values (?, ?, ?, ?, ?)";
    private final String GET_USER_BY_LOGIN = "select * from users where login=?";
    private final String GET_USER_BY_ID = "select * from users where id=?";
    private final String GET_USERS_COUNT = "select count(*) from users where role = 'user'";

    //@Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user) {
        jdbcTemplate.update(ADD_NEW_USER, user.getName(), user.getSurname(), user.getEmail(), user.getLogin(), user.getPassword());
    }

    public void update(User user) {
        //
    }

    public List<User> listUsers() {
        return jdbcTemplate.query(SELECT_ALL_USERS, new UserRowMapper());
    }

    public User getUserById(int id) {
        return null;
    }

    /**
     * @param login
     * @return query and only query! if db returned null - exception
     */
    public List<User> getUserByLogin(String login) {
        return jdbcTemplate.query(GET_USER_BY_LOGIN, new Object[]{login}, new UserRowMapper());
    }

    public void delete(int id) {
    }

    @Override
    public boolean isAdmin(User user) {
        return user.getRole().equals("admin");
    }

    @Override
    public int getUsersCount() {
        try {
            return jdbcTemplate.queryForObject(GET_USERS_COUNT, Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return 0;
        }
    }
}

