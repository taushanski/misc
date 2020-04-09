package object_oriented_design.callCenter;

public enum Rank {
    Responder(0),
    Manager(1),
    Director(2);
    private int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
