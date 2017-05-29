package by.masarnovsky.dao.jdbc;

import by.masarnovsky.dao.AnswerDAO;
import by.masarnovsky.dao.rowmapper.AnswerRowMapper;
import by.masarnovsky.model.Answer;
import by.masarnovsky.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnswerDAOJdbcImpl implements AnswerDAO {
    JdbcTemplate jdbcTemplate;

    private final String GET_ANSWERS_FOR_QUESTION = "select * from answers where questionId=?";
    private final String INSERT_ANSWER = "insert into answers(questionId, text, isRight) values(?,?,?)";
    private final String UPDATE_ANSWER = "update answers set questionId=?, text=?, isRight=? where id=?";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Answer> getAnswersForQuestion(Question q) {
        return getAnswersForQuestion(q.getId());
    }

    public List<Answer> getAnswersForQuestion(int id) {
        return jdbcTemplate.query(GET_ANSWERS_FOR_QUESTION, new Object[]{id}, new AnswerRowMapper());
    }

    @Override
    public void save(Answer a) {
        jdbcTemplate.update(INSERT_ANSWER, new Object[]{a.getQuestionId(), a.getText(), a.isRight()});
    }

    @Override
    public int update(Answer a) {
        return jdbcTemplate.update(UPDATE_ANSWER, new Object[]{a.getQuestionId(), a.getText(), a.isRight(), a.getId()});
    }
}
