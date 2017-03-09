package by.masarnovsky.dao.rowmapper;

import by.masarnovsky.model.Result;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultRowMapper implements RowMapper<Result> {
    public Result mapRow(ResultSet resultSet, int i) throws SQLException {
        Result result = new Result(
                resultSet.getInt("id"),
                resultSet.getInt("userId"),
                resultSet.getInt("module"),
                resultSet.getInt("result"),
                resultSet.getDate("date")
        );
        return result;
    }
}
