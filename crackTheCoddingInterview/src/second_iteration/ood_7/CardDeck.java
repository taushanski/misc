package second_iteration.ood_7;

import java.util.NoSuchElementException;

public class CardDeck {

    enum Suit {
        Club(0), Diamond(1), Heart(2), Spade(3);

        private final int value;

        Suit(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Suit getSuitForValue(int value) {
            for (Suit nextSuit : Suit.values()) {
                if (nextSuit.getValue() == value) {
                    return nextSuit;
                }
            }
            throw new NoSuchElementException();
        }
    }
}
