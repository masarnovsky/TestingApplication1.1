package by.masarnovsky.controller;

import by.masarnovsky.TestType;
import by.masarnovsky.model.Answer;
import by.masarnovsky.model.Question;
import by.masarnovsky.model.User;

import java.util.List;
import java.util.Map;

public class CurrentTestingSessionStorage {
    private User user;
    private TestType testType;
    private List<Question> questions;
    private boolean[] questionsAnsw;
    private Map<Integer, List<Answer>> answersMap;
    private String message;
}
