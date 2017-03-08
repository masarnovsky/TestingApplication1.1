package by.masarnovsky.dao.rowmapper;


import by.masarnovsky.model.Question;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionRowMapper implements RowMapper<Question> {
    public Question mapRow(ResultSet resultSet, int i) throws SQLException {
        Question question = new Question(
                resultSet.getInt("id"),
                resultSet.getInt("module"),
                resultSet.getString("question"),
                resultSet.getString("img"),
                resultSet.getInt("type")
        );
        return question;
    }
}
