package by.masarnovsky.dao;

import by.masarnovsky.model.Question;

import java.util.List;

public interface QuestionDAO {
    List<Question> getQuestionSet(int id);
    Question getQuestionById(int id);
//    void addQuestion(Question q);
}
