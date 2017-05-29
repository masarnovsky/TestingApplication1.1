package by.masarnovsky.service;

import by.masarnovsky.model.Question;
import by.masarnovsky.model.QuestionType;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestionSet(int count);
    List<Question> getQuestionsForModule(int moduleId, int count);
    List<Question> getAllQuestionsForModule(int module);
    Question getQuestionById(int id);
    int save(Question q);
    int update(Question q);
    List<QuestionType> getTypes();
}
