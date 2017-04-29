package by.masarnovsky.dao;

import by.masarnovsky.model.Question;
import by.masarnovsky.model.QuestionType;

import java.util.List;

public interface QuestionDAO {
    List<Question> getQuestionSet(int count);
    List<Question> getQuestionsForModule(int moduleId, int count);
    Question getQuestionById(int id);
    int addQuestion(Question q);
    List<QuestionType> getTypes();
}
