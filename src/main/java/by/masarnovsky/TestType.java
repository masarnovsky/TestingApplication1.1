package by.masarnovsky;

public enum TestType {
    TRAINING(0),
    TESTING(1);

    private int type;

    private TestType(int type){
        this.type = type;
    }

    public int getType(){
        return type;
    }
}
