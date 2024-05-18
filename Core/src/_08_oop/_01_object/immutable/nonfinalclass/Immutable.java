package _08_oop._01_object.immutable.nonfinalclass;

public /*final*/ class Immutable {

    private final int value;

    public Immutable(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}