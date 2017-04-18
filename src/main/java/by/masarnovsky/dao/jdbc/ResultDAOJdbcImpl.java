package by.masarnovsky.dao.jdbc;

import by.masarnovsky.dao.ResultDAO;
import by.masarnovsky.dao.rowmapper.ResultRowMapper;
import by.masarnovsky.model.Result;
import by.masarnovsky.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ResultDAOJdbcImpl implements ResultDAO {
    private JdbcTemplate jdbcTemplate;

    private final String GET_USER_RESULT = "select * from results where userId=?";
    private final String GET_USER_RESULT_BY_MODULE = "select * from results where userId=? and module=?";
    private final String GET_USER_STRING_RESULT_BY_MODULE = "select result from results where userId=? and module=?";
    private final String INSERT_RESULT = "insert into results(userId, module, result) values(?, ?, ?)";

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
    public void insertResult(Result result) {
        insertResult(result.getUserId(), result.getModule(), result.getResult());
    }

    @Override
    public void insertResult(int userId, int moduleId, String result) {
        jdbcTemplate.update(INSERT_RESULT, userId, moduleId, result);
    }
}
