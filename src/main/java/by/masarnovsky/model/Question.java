package by.masarnovsky.model;

public class Question {
    private int id;
    private int module;
    private String question;
    private String img;
    private int type;

    public Question(int id, int module, String question, String img, int type) {
        this.id = id;
        this.module = module;
        this.question = question;
        this.img = img;
        this.type = type;
    }

    public Question(){}

    public Question(int module, String question, String img, int type) {
        this.module = module;
        this.question = question;
        this.img = img;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Question{");
        sb.append("id=").append(id);
        sb.append(", module=").append(module);
        sb.append(", question='").append(question).append('\'');
        sb.append(", img='").append(img).append('\'');
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
