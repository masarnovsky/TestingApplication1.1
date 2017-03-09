package by.masarnovsky.model;

public class Answer {
    private int id;
    private int questionId;
    private String text;
    private boolean isRight;

    public Answer() {
    }

    public Answer(int id, int questionId, String text, boolean isRight) {
        this.id = id;
        this.questionId = questionId;
        this.text = text;
        this.isRight = isRight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Answer{");
        sb.append("id=").append(id);
        sb.append(", questionId=").append(questionId);
        sb.append(", text='").append(text).append('\'');
        sb.append(", isRight=").append(isRight);
        sb.append('}');
        return sb.toString();
    }
}
