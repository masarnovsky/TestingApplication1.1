package by.masarnovsky.dao;

import by.masarnovsky.model.Answer;
import by.masarnovsky.model.Question;

import java.util.List;

public interface AnswerDAO {
    List<Answer> getAnswersForQuestion(Question q);
    List<Answer> getAnswersForQuestion(int id);
    void save(Answer a);
    int update(Answer a);
}
