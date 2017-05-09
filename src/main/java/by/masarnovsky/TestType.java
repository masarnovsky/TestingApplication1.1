package by.masarnovsky;

public enum TestType {
    TRAINING(3),
    TESTING(6);

    private int type;

    private TestType(int type){
        this.type = type;
    }

    public int getIntValue(){
        return type;
    }
}
