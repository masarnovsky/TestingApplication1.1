package by.masarnovsky;

public enum TestType {
    TRAINING(3, "training"),
    TESTING(6, "testing");

    private int type;
    private String name;

    private TestType(int type, String name){
        this.type = type;
        this.name = name;
    }

    public String getStringValue() {
        return name;
    }

    public boolean equalsName(String other) {
        return name.equals(other);
    }

    public int getIntValue(){
        return type;
    }
}
