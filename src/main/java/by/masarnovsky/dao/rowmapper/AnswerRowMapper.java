package by.masarnovsky.dao.rowmapper;

import by.masarnovsky.model.Answer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnswerRowMapper implements RowMapper<Answer> {
    public Answer mapRow(ResultSet resultSet, int i) throws SQLException {
        Answer answer = new Answer(
                resultSet.getInt("id"),
                resultSet.getInt("questionId"),
                resultSet.getString("text"),
                resultSet.getBoolean("isRight")
        );
        return answer;
    }
}
