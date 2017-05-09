package by.masarnovsky.model;

import java.util.List;

public class QuestionWithAnswers {
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