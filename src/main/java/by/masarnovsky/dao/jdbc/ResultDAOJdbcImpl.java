package by.masarnovsky.dao.jdbc;

import by.masarnovsky.dao.ResultDAO;
import by.masarnovsky.dao.rowmapper.ResultRowMapper;
import by.masarnovsky.model.Result;
import by.masarnovsky.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ResultDAOJdbcImpl implements ResultDAO {
    private JdbcTemplate jdbcTemplate;

    private final String GET_USER_RESULT = "select * from results where userId=? order by date desc";
    private final String GET_USER_RESULT_BY_MODULE = "select * from results where userId=? and module=?";
    private final String GET_USER_STRING_RESULT_BY_MODULE = "select result from results where userId=? and module=?";
    private final String INSERT_RESULT = "insert into results(userId, module, result) values(?, ?, ?)";
    private final String GET_PASSED_TESTS_COUNT = "select count(*) from results where result = 'passed'";
    private final String GET_FAILED_TESTS_COUNT = "select count(*) from results where result = 'failed'";
    private final String GET_PASSED_TESTS_COUNT_FOR_USER = "select count(*) from results where result = 'passed' and userId = ?";
    private final String GET_FAILED_TESTS_COUNT_FOR_USER = "select count(*) from results where result = 'failed' and userId = ?";
    private final String GET_USERS_COUNT_FOR_MODULE = "SELECT COUNT(*) AS cnt FROM (SELECT userId from results WHERE module=? GROUP BY userId) AS t;";
    private final String GET_PASSED_TESTS_COUNT_FOR_MODULE = "select count(*) from results where result='passed' and module=?";
    private final String GET_FAILED_TESTS_COUNT_FOR_MODULE = "select count(*) from results where result='failed' and module=?";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Result> getAllResults() {
        return null;
    }

    @Override
    public int getUsersCountForModule(int moduleId) {
        try {
            return jdbcTemplate.queryForObject(GET_USERS_COUNT_FOR_MODULE, new Object[]{moduleId}, Integer.class);
        } catch (EmptyResultDataAccessException e){
            return 0;
        }
    }

    public List<Result> getUserResult(User user) {
        return getUserResult(user.getId());
    }

    public List<Result> getUserResult(int id) {
        return jdbcTemplate.query(GET_USER_RESULT, new Object[]{id}, new ResultRowMapper());
    }

    @Override
    public List<Result> getUserResultByModule(int idUser, int idModule) {
        return jdbcTemplate.query(GET_USER_RESULT_BY_MODULE, new Object[]{idUser, idModule}, new ResultRowMapper());
    }

    @Override
    public List<String> getUserStringResultByModule(int idUser, int idModule) {
        return jdbcTemplate.query(GET_USER_STRING_RESULT_BY_MODULE, new Object[]{idUser, idModule}, new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString("result");
            }
        });
    }

    @Override
    public void save(Result result) {
        save(result.getUserId(), result.getModule(), result.getResult());
    }

    @Override
    public void save(int userId, int moduleId, String result) {
        jdbcTemplate.update(INSERT_RESULT, userId, moduleId, result);
    }

    @Override
    public int getPassedTestsCount() {
        try {
            return jdbcTemplate.queryForObject(GET_PASSED_TESTS_COUNT, Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return 0;
        }

    }

    @Override
    public int getFailedTestsCount() {
        try {
            return jdbcTemplate.queryForObject(GET_FAILED_TESTS_COUNT, Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return 0;
        }
    }

    @Override
    public int getPassedTestsCountForUser(User user) {
        try {
            return jdbcTemplate.queryForObject(GET_PASSED_TESTS_COUNT_FOR_USER, new Object[]{user.getId()}, Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return 0;
        }
    }

    @Override
    public int getFailedTestsCountForUser(User user) {
        try {
            return jdbcTemplate.queryForObject(GET_FAILED_TESTS_COUNT_FOR_USER, new Object[]{user.getId()}, Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return 0;
        }
    }

    @Override
    public int getPassedTestsCountForModule(int module) {
        try {
            return jdbcTemplate.queryForObject(GET_PASSED_TESTS_COUNT_FOR_MODULE, new Object[]{module}, Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return 0;
        }
    }

    @Override
    public int getFailedTestsCountForModule(int module) {
        try {
            return jdbcTemplate.queryForObject(GET_FAILED_TESTS_COUNT_FOR_MODULE, new Object[]{module}, Integer.class);
        } catch (EmptyResultDataAccessException e) {
            return 0;
        }
    }
}
