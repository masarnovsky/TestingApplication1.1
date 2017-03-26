package by.masarnovsky.dao.jdbc;

import by.masarnovsky.dao.ResultDAO;
import by.masarnovsky.dao.rowmapper.ResultRowMapper;
import by.masarnovsky.model.Result;
import by.masarnovsky.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResultDAOJdbcImpl implements ResultDAO {
    private JdbcTemplate jdbcTemplate;

    private final String GET_USER_RESULT = "select * from results where userId=?";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Result> getAllResults() {
        return null;
    }

    public List<Result> getUserResult(User user) {
        return getUserResult(user.getId());
    }

    public List<Result> getUserResult(int id) {
        return jdbcTemplate.query(GET_USER_RESULT, new Object[]{id}, new ResultRowMapper());
    }
}
