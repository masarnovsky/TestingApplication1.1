package by.masarnovsky.model;

public class QuestionType {
    private int id;
    private String descr;

    public QuestionType() {
    }

    public QuestionType(int id, String descr) {

        this.id = id;
        this.descr = descr;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuestionType{");
        sb.append("id=").append(id);
        sb.append(", descr='").append(descr).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
