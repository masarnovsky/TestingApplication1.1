package by.masarnovsky.model;

public class Module {
    private int id;
    private String theme;

    public Module() {
    }

    public Module(int id, String theme) {
        this.id = id;
        this.theme = theme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Module{");
        sb.append("id=").append(id);
        sb.append(", theme='").append(theme).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
