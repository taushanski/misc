package dynamic_programing_and_recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringPermutations {

    public static void main(String[] args) {
        String word = "abcd1234";
        List<String> permutations = getPerms(word);
        System.out.println("permutations.size() = " + permutations.size());
        System.out.println("permutations = " + permutations);

        System.out.println("getPermutationsDups(\"aaba\") = " + getPermutationsDups("aaba"));
    }

    // Approach 1: Building from permutations of first n-1 characters
    private static List<String> getPerms(String word) {
        if (word == null) {
            return null;
        }

        List<String> permutations = new ArrayList<>();
        if (word.length() == 0) { // base case
            permutations.add("");
            return permutations;
        }

        char first = word.charAt(0);// take the first character
        String reminder = word.substring(1);// remove the first characters

        List<String> words = getPerms(reminder);
        for (String nextWord : words) {
            for (int i = 0; i <= nextWord.length(); i++) {
                String s = insertCharAt(nextWord, first, i);
                permutations.add(s);
            }
        }

        return permutations;
    }

    /*Insert char c at index i in word.*/
    private static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }

    /*Approach 2: Building from permutations of all n-1 character substrings.*/
    private static List<String> getPerms2(String reminder) {
        int len = reminder.length();
        List<String> result = new ArrayList<>();

        /*Base case*/
        if (len == 0) {
            result.add("");
            return result;
        }

        for (int i = 0; i < len; i++) {
            /*Remove char i and find permutations of remaining characters */
            String before = reminder.substring(0, i);
            String after = reminder.substring(i + 1, len);
            List<String> partials = getPerms2(before + after);

            /*prepend char i to each permutation*/
            for (String partial : partials) {
                result.add(reminder.charAt(i) + partial);
            }

        }
        return result;
    }

    /*
     * Alternatively, instead of passing the permutations back up the stack, we can push the prefix down the stack.
     * When we get to the bottom (base case), prefix holds a full permutation.
     * The runtime of this is O(n^2*n!)
     */
    private static List<String> getPerms3(String word) {
        List<String> result = new ArrayList<>();
        getPerms3("", word, result);
        return result;
    }

    private static void getPerms3(String prefix, String reminder, List<String> result) {
        int len = reminder.length();
        if (len == 0) {
            result.add(prefix);
        }

        for (int i = 0; i < len; i++) {
            String before = reminder.substring(0, i);
            String after = reminder.substring(i + 1, len);
            char c = reminder.charAt(i);
            getPerms3(prefix + c, before + after, result);
        }
    }

    /*There could be duplicate characters in the input string */
    private static List<String> getPermutationsDups(String word) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> characterFrequencyMap = buildFreqTable(word);
        findPermutations(characterFrequencyMap, "", word.length(), result);
        return result;

    }

    private static Map<Character, Integer> buildFreqTable(String word) {
        Map<Character, Integer> result = new HashMap<>();
        for (char nextChar : word.toCharArray()) {
            result.merge(nextChar, 1, (oldValue, newValue) -> oldValue + newValue);
        }
        return result;
    }

    private static void findPermutations(Map<Character, Integer> characterFrequencyMap, String prefix, int remaining,
            List<String> result) {

        /*BAse case peermutation has been completed*/
        if (remaining == 0) {
            result.add(prefix);
            return;
        }

        /*Try remaining letters for next char, and generate remaining permutations.*/
        for (Character c : characterFrequencyMap.keySet()) {
            int count = characterFrequencyMap.get(c);
            if (count > 0) {
                characterFrequencyMap.put(c, count - 1);
                findPermutations(characterFrequencyMap, prefix + c, remaining - 1, result);
                characterFrequencyMap.put(c, count);
            }

        }
    }
}
