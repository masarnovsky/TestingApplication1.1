package by.masarnovsky.service.impl;

import by.masarnovsky.dao.AnswerDAO;
import by.masarnovsky.model.Answer;
import by.masarnovsky.model.Question;
import by.masarnovsky.service.AnswerService;

import java.util.List;

public class AnswerServiceImpl implements AnswerService {
    private AnswerDAO answerDAO;

    public void setAnswerDAO(AnswerDAO answerDAO) {
        this.answerDAO = answerDAO;
    }

    public List<Answer> getAnswersForQuestion(Question q) {
        return answerDAO.getAnswersForQuestion(q);
    }

    public List<Answer> getAnswersForQuestion(int id) {
        return answerDAO.getAnswersForQuestion(id);
    }
}
