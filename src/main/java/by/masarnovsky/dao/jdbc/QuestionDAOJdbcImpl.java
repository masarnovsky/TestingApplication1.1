package by.masarnovsky.dao.jdbc;

import by.masarnovsky.dao.QuestionDAO;
import by.masarnovsky.dao.rowmapper.QuestionRowMapper;
import by.masarnovsky.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDAOJdbcImpl implements QuestionDAO{
    private JdbcTemplate jdbcTemplate;

    private final String GET_RANDOM_QUESTION_SET = "select * from questions order by rand() limit ?";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Question> getQuestionSet(int count) {
        return jdbcTemplate.query(GET_RANDOM_QUESTION_SET, new Object[]{count} ,new QuestionRowMapper());
    }

    public Question getQuestionById(int id) {
        return null;
    }
}
