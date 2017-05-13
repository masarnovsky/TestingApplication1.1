package by.masarnovsky.model;

import by.masarnovsky.TestType;

import java.util.ArrayList;
import java.util.List;

public class CurrentTestingSessionStorage {
    private User user;
    private TestType testType;
    private String message;
    private List<QuestionWithAnswers> questionWithAnswersList;
    private Boolean[] rightAnswers;
    private int currentIndex;

    public void addNewQuestionWithAnswers(Question question, List<Answer> answers){
        questionWithAnswersList.add(new QuestionWithAnswers(question, answers));
    }

    public void addQuestionsFromList(List<Question> questions){
        for (Question q: questions){
            addNewQuestion(q);
        }
        rightAnswers = new Boolean[questions.size()];
    }

    public Boolean[] getRightAnswers() {
        return rightAnswers;
    }

    public void setUserAnswerToAnswersArray(boolean isTrue){
        rightAnswers[currentIndex] = isTrue;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public QuestionWithAnswers getCurrentQuestion() {
        return questionWithAnswersList.get(currentIndex);
    }

    public int getRightAnswerId() {
        return getCurrentQuestion().getRightAnswerId();
    }

    public void setUserAnswerToQuestion(boolean isTrue){
        getCurrentQuestion().setUserChoseRightAnswer(isTrue);
    }

    public void setThatUserSeeQuestion(boolean isSee){
        getCurrentQuestion().setUserSeeThisQuestion(isSee);
    }

    public QuestionWithAnswers toNextQuestion() {
        if (currentIndex >= questionWithAnswersList.size()-1){
            return null;
        }
        return questionWithAnswersList.get(++currentIndex);
    }

    public QuestionWithAnswers toPreviousQuestion() {
        if (currentIndex <= 0){
            return null;
        }
        return questionWithAnswersList.get(--currentIndex);
    }

    public QuestionWithAnswers getNextQuestion() {
        if (currentIndex >= questionWithAnswersList.size()-1){
            return null;
        }
        return questionWithAnswersList.get(currentIndex + 1);
    }

    public QuestionWithAnswers getPreviousQuestion() {
        if (currentIndex <= 0){
            return null;
        }
        return questionWithAnswersList.get(currentIndex - 1);
    }

    public int getQuestionCount() {
        return questionWithAnswersList.size();
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

