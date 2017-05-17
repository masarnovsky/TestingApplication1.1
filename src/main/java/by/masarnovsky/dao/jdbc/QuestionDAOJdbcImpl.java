package by.masarnovsky.dao.jdbc;

import by.masarnovsky.dao.QuestionDAO;
import by.masarnovsky.dao.rowmapper.QuestionRowMapper;
import by.masarnovsky.dao.rowmapper.QuestionTypeRowMapper;
import by.masarnovsky.model.Question;
import by.masarnovsky.model.QuestionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class QuestionDAOJdbcImpl implements QuestionDAO{
    private JdbcTemplate jdbcTemplate;

    private final String GET_RANDOM_QUESTION_SET = "select * from questions order by rand() limit ?";
    private final String GET_QUESTIONS_FOR_MODULE = "select * from questions where module = ? order by rand() limit ?";
    private final String GET_QUESTION_TYPES = "select * from questionTypes";
    private final String GET_LAST_ID = "select LAST_INSERT_ID()";
    private final String INSERT_QUESTION = "insert into questions(module, question, img, type) values(?,?,?,?)";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Question> getQuestionSet(int count) {
        return jdbcTemplate.query(GET_RANDOM_QUESTION_SET, new Object[]{count} ,new QuestionRowMapper());
    }

    @Override
    public List<Question> getQuestionsForModule(int moduleId, int count) {
        return jdbcTemplate.query(GET_QUESTIONS_FOR_MODULE, new Object[]{moduleId, count}, new QuestionRowMapper());
    }

    public Question getQuestionById(int id) {
        return null;
    }

    @Override
    @Transactional
    public int save(Question q) {
        jdbcTemplate.update(INSERT_QUESTION, new Object[]{q.getModule(), q.getQuestion(), q.getImg(), q.getType()});
        return jdbcTemplate.queryForObject(GET_LAST_ID, Integer.class);
    }

    @Override
    public List<QuestionType> getTypes() {
        return jdbcTemplate.query(GET_QUESTION_TYPES, new QuestionTypeRowMapper());
    }
}
