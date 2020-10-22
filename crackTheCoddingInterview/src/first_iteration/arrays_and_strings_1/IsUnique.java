package first_iteration.arrays_and_strings_1;

public class IsUnique {

    public static void main(String... args) {
        String testString = "a";
        System.out.printf("Is the following string:%s unique: %b", testString, isUniqueCharacters(testString, 256));
    }

    private static boolean isUniqueCharacters(String testString, int charsetSize) {
        if (testString.length() > charsetSize) {
            return false;
        }
        boolean[] charsetChars = new boolean[charsetSize];
        for (int i = 0; i < testString.length(); i++) {
            int nextChar = testString.charAt(i);
            if (charsetChars[nextChar]) {
                return false;
            }
            charsetChars[nextChar] = true;
        }
        return true;
    }
}
