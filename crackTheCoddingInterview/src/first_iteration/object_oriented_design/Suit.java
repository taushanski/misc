package first_iteration.object_oriented_design;

public enum Suit {

    Club(0),
    Diamond(1),
    Heart(2),
    Spade(3);
    private int value;

    private Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuitFromValue(int value) {
        for (Suit nextSuit : Suit.values()) {
            if (nextSuit.getValue() == value) {
                return nextSuit;
            }
        }
        return null;
    }
}
