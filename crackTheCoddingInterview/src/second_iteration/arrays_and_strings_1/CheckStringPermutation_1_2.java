package second_iteration.arrays_and_strings_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CheckStringPermutation_1_2 {

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "dcba";
        System.out.println("checkPermutationsBySorting(str1, str2) = " + checkPermutationsBySorting(str1, str2));
        System.out.println("checkPermutationsByHashMap(str1, str2) = " + checkPermutationsByHashMap(str1, str2));
    }


    private static boolean checkPermutationsBySorting(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        String src1Sorted = sort(str1); // O(n*log(n))
        String src2Sorted = sort(str2);// O(n*log(n))
        return src1Sorted.equals(src2Sorted);// O(n)
    }

    private static String sort(String str1) {
        char[] chars = str1.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static boolean checkPermutationsByHashMap(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Integer> str1Chars = new HashMap<>();
        for (char nextChar : str1.toCharArray()) {
            str1Chars.compute(nextChar, (character, integer) -> Objects.isNull(integer) ? 1 : integer + 1);
        }
        for (char nextChar : str2.toCharArray()) {
            if (Objects.isNull(str1Chars.get(nextChar))) {
                return false;
            }
        }
        return true;
    }


}
