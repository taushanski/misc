package arrays_and_strings_1;

public class PalindromePermuntation {

    public static void main(String... args) {
        String in = "Tact Coa";

        printPermuntations(in, "");

    }

    private static void printPermuntations(String str, String suffix) {
        if (str.isEmpty()) {
            System.out.println(suffix);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) + str.substring(i + 1);

            // Recurvise call
            printPermuntations(ros, suffix + ch);
        }

    }


}
