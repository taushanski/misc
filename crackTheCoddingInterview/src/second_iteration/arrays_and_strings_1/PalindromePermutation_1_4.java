package second_iteration.arrays_and_strings_1;

public class PalindromePermutation_1_4 {

    public static void main(String[] args) {
        String phrase = "Tact Coa";
        System.out.println(
                "isPermutationOfPalindromeWithHashTable(phrase) = " + isPermutationOfPalindromeWithHashTable(phrase));

        System.out.println("Character.getNumericValue('a') = " + Character.getNumericValue('A'));
        System.out.println("(int)'a' = " + (int)'A');
    }

    private static boolean isPermutationOfPalindromeWithHashTable(String phrase) {
        int[] table = buildCharsFrequencyTable(phrase);
        return false;
    }

    private static int[] buildCharsFrequencyTable(String phrase) {
        
        return new int[0];
    }
}
