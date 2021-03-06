package by.masarnovsky.model;

import java.util.List;

public class QuestionWithAnswers {
    private Question question  = null;
    private List<Answer> answers  = null;
    private Boolean isUserChoseRightAnswer = null;
    private Boolean isUserSeeThisQuestion  = null;

    public QuestionWithAnswers(Question question, List<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }

    public QuestionWithAnswers(Question question){
        this.question = question;
    }

    public int getRightAnswerId() {
        int id = -1;
        for (Answer a: answers){
            if (a.isRight() == true) {
                id = a.getId();
                break;
            }
        }
        return id;
    }

    public Boolean isUserChoseRightAnswer() {
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

    public Boolean isUserSeeThisQuestion() {
        return isUserSeeThisQuestion;
    }

    public void setUserSeeThisQuestion(boolean userSeeThisQuestion) {
        isUserSeeThisQuestion = userSeeThisQuestion;
    }
}
