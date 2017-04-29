package by.masarnovsky.dao;

import by.masarnovsky.model.Answer;
import by.masarnovsky.model.Question;

import java.util.List;

public interface AnswerDAO {
    List<Answer> getAnswersForQuestion(Question q);
    List<Answer> getAnswersForQuestion(int id);
    void insertAnswer(Answer a);
}
