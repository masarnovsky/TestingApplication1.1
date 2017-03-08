package by.masarnovsky.dao.jdbc;

import by.masarnovsky.dao.AnswerDAO;
import by.masarnovsky.dao.rowmapper.AnswerRowMapper;
import by.masarnovsky.model.Answer;
import by.masarnovsky.model.Question;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AnswerJdbcDAOImpl implements AnswerDAO {
    JdbcTemplate jdbcTemplate;

    private final String GET_ANSWERS_FOR_QUESTION = "select * from answers where questionId=?";

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Answer> getAnswersForQuestion(Question q) {
        return getAnswersForQuestion(q.getId());
    }

    public List<Answer> getAnswersForQuestion(int id) {
        return jdbcTemplate.query(GET_ANSWERS_FOR_QUESTION, new Object[]{id}, new AnswerRowMapper());
    }
}
