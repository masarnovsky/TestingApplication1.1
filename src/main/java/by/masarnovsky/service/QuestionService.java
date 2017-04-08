package by.masarnovsky.service;

import by.masarnovsky.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestionSet(int count);
    List<Question> getQuestionsForModule(int moduleId, int count);
    Question getQuestionById(int id);
}
