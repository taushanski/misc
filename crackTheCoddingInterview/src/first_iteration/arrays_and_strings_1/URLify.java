package first_iteration.arrays_and_strings_1;

public class URLify {

    public static void main(String... args) {
        String st1 = "Mr John Smith    ";

        char[] inputChars = st1.toCharArray();
        replaceSpaces(inputChars, 13);
        System.out.printf("The following string [%s] was converted to [%s]%n", st1, new String(inputChars), 11);
    }

    private static void replaceSpaces(char[] input, int trueLength) {
        int spaceCount = 0;
        //        for (char nextChar : input) {
        for (int i = 0; i < trueLength; i++) {
            char nextChar = input[i];
            if (nextChar == ' ') {
                spaceCount++;
            }
        }

        int index = trueLength + spaceCount * 2;
        if (trueLength < input.length) {
            input[trueLength] = '\0';
        }
        for (int i = trueLength - 1; i >= 0; i--) {
            if (input[i] == ' ') {
                input[index - 1] = '0';
                input[index - 2] = '2';
                input[index - 3] = '%';
                index -= 3;
            } else {
                input[index - 1] = input[i];
                index--;
            }

        }

    }


}
