package by.masarnovsky.dao.jdbc;

import by.masarnovsky.dao.QuestionDAO;
import by.masarnovsky.dao.rowmapper.QuestionRowMapper;
import by.masarnovsky.model.Question;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class QuestionJdbcDAOImpl implements QuestionDAO{
    private JdbcTemplate jdbcTemplate;

    private final String GET_RANDOM_QUESTION_SET = "select * from questions order by rand() limit 3";

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Question> getQuestionSet(int id) {
        return jdbcTemplate.query(GET_RANDOM_QUESTION_SET, new QuestionRowMapper());
    }

    public Question getQuestionById(int id) {
        return null;
    }
}
