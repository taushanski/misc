package first_iteration.sorting_and_serching;

import java.util.Arrays;
import java.util.Comparator;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] words = {"ala", "laa", "nica", "tupanica"};
        Arrays.sort(words, new AnagramsComparator());
        System.out.println("Arrays.toString(words) = " + Arrays.toString(words));
    }

    private static class AnagramsComparator implements Comparator<String> {

        @Override
        public int compare(String word1, String word2) {
            return sortChars(word1).compareTo(sortChars(word2));
        }

        private String sortChars(String s) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }

}
