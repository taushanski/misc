package second_iteration.arrays_and_strings_1;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*Is Unique: Implement an algorithm to determine if a string has all unique characters.
What if you cannot use additional data structures?*/
public class IsUnique_1_1 {

    public static void main(String[] args) {
        String input = "abcdefgh1324";
        System.out.println("isUnique_withMap(input) = " + isUnique_withMap(input));
        System.out.println("isUnique_withBooleanArr(input, 280) = " + isUnique_withBooleanArr(input, 280));
        System.out.println("isUnique_withBitVector(input) = " + isUnique_withBitVector(input));
    }

    private static boolean isUnique_withMap(String input) {
        Map<Character, Boolean> containedChars = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char nextChar = input.charAt(i);
            if (Objects.nonNull(containedChars.putIfAbsent(nextChar, true))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isUnique_withBooleanArr(String input, int charSetSize) {
        if (input.length() > charSetSize) {
            return false;
        }

        boolean[] charSet = new boolean[charSetSize];
        for (int i = 0; i < input.length(); i++) {
            int charPosition = input.charAt(i);
            if (charSet[charPosition]) { // already found this char
                return false;
            }
            charSet[charPosition] = true;
        }
        return true;
    }

    private static boolean isUnique_withBitVector(String input) {
        BitSet charSet = new BitSet();
        for (int i = 0; i < input.length(); i++) {
            int charPosition = input.charAt(i);
            if (charSet.get(charPosition)) {
                return false;
            }
            charSet.set(charPosition);
        }
        return true;
    }


}
