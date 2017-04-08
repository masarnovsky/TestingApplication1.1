package by.masarnovsky.service;

import by.masarnovsky.dao.QuestionDAO;
import by.masarnovsky.model.Question;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {
    private QuestionDAO questionDAO;

    public void setQuestionDAO(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    public List<Question> getQuestionSet(int id) {
        return questionDAO.getQuestionSet(id);
    }

    @Override
    public List<Question> getQuestionsForModule(int moduleId, int count) {
        return questionDAO.getQuestionsForModule(moduleId, count);
    }

    public Question getQuestionById(int id) {
        return questionDAO.getQuestionById(id);
    }
}
