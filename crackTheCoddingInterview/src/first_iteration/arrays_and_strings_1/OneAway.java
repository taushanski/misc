package first_iteration.arrays_and_strings_1;

public class OneAway {

    public static void main(String... args) {
        String first = "pale";
        String second = "bale";

        System.out.printf("Are [%s] and [%s] one edit away: %b", first, second, oneEditAway(first, second));


    }

    private static boolean oneEditAway(String first, String second) {
        if (first.equals(second)) {
            return true;
        } else if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        } else if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }
        return false;
    }

    private static boolean oneEditReplace(String first, String second) {
        boolean foundDifference = false;
        for (int i = 0; i < first.length(); i++) {
            char firstNextChar = first.charAt(i);
            char secondNextChar = second.charAt(i);
            if (firstNextChar != secondNextChar) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    private static boolean oneEditInsert(String shorter, String longer) {
        boolean foundDifference = false;
        int shorterStringIndex = 0, longerStringIndex = 0;

        while (shorterStringIndex < shorter.length() && longerStringIndex < longer.length()) {
            if (shorter.charAt(shorterStringIndex) != longer.charAt(longerStringIndex)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
                longerStringIndex++;
            } else {
                shorterStringIndex++;
                longerStringIndex++;
            }
        }
        return true;
    }


}
