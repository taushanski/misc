public class CeasarCipherEncryptor {

    public static void main(String[] args) {
        String input = "xyz";
        int key = 28;

        System.out.println("Character.getNumericValue(\"a\"); = " + Character.getNumericValue('a'));
        System.out.println("(int) 'a' = " + (int) 'a');
        System.out.println("encrypt(input) = " + encrypt(input, key));
    }

    private static String encrypt(String input, int key) {
        char firstLetter = 'a';
        char lastLetter = 'z';
        System.out.println("a=" + (int) firstLetter + "z=" + (int) lastLetter);
        int alphabetLetters = lastLetter - firstLetter + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char nextChar = input.charAt(i);
            int nextCharNewIndex = nextChar - firstLetter + key;
            char nextEncodedChar = (char) ((nextCharNewIndex % alphabetLetters) + firstLetter);
            sb.append(nextEncodedChar);
        }
        return sb.toString();
    }

}
