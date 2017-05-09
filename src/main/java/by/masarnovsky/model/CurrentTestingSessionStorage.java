package by.masarnovsky.model;

import by.masarnovsky.TestType;

import java.util.ArrayList;
import java.util.List;

public class CurrentTestingSessionStorage {
    private User user;
    private TestType testType;
    private String message;
    private List<QuestionWithAnswers> questionWithAnswersList;
    private int currentIndex;

    public void addNewQuestionWithAnswers(Question question, List<Answer> answers){
        questionWithAnswersList.add(new QuestionWithAnswers(question, answers));
    }

    public void addQuestionsFromList(List<Question> questions){
        for (Question q: questions){
            addNewQuestion(q);
        }
    }

    public void addNewQuestion(Question question){
        questionWithAnswersList.add(new QuestionWithAnswers(question));
    }

    public QuestionWithAnswers getQuestionById(int id){
        QuestionWithAnswers question = null;
        for (QuestionWithAnswers q: questionWithAnswersList){
            if (q.getQuestionId() == id) {
                question = q;
                break;
            }
        }
        return question;
    }

    public CurrentTestingSessionStorage(User user, TestType testType){
        this.user = user;
        this.testType = testType;
        this.questionWithAnswersList = new ArrayList<>();
        this.currentIndex = 0;
    }

    public User getUser() {
        return user;
    }

    public TestType getTestType() {
        return testType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<QuestionWithAnswers> getQuestionWithAnswersList() {
        return questionWithAnswersList;
    }

    public void setQuestionWithAnswersList(List<QuestionWithAnswers> questionWithAnswersList) {
        this.questionWithAnswersList = questionWithAnswersList;
    }
}

class QuestionWithAnswers {
    private Question question;
    private List<Answer> answers;
    private boolean isUserChoseRightAnswer;

    public QuestionWithAnswers(Question question, List<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }

    public QuestionWithAnswers(Question question){
        this.question = question;
    }

    public boolean isUserChoseRightAnswer() {
        return isUserChoseRightAnswer;
    }

    public void setUserChoseRightAnswer(boolean userChoseRightAnswer) {
        isUserChoseRightAnswer = userChoseRightAnswer;
    }

    public int getQuestionId() {
        return question.getId();
    }

    public Answer getAnswer(int ind) {
        return answers.get(ind);
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
