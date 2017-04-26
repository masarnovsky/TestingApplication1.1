package by.masarnovsky.dao.rowmapper;

import by.masarnovsky.model.QuestionType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionTypeRowMapper implements RowMapper<QuestionType> {
    @Override
    public QuestionType mapRow(ResultSet resultSet, int i) throws SQLException {
        return new QuestionType(
                resultSet.getInt("id"),
                resultSet.getString("descr")
        );
    }
}
