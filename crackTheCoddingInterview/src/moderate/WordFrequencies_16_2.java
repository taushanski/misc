package moderate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencies_16_2 {
    private static Map<String, Integer> dictionary = new HashMap<>();

    public static void main(String[] args) {
        String[] book = {"hi", "my", "friend", "Hi", "hI "};
        String word = "hi";
        System.out.printf("The word %s appears %d times", word, countWordFrequencies(book, word));
    }

    // O(n)
    private static long countWordFrequencies(String[] book, String word) {
        String trimmedWord = word.trim().toLowerCase();
        return Arrays.stream(book).filter(nextWord -> nextWord.trim().toLowerCase().equals(trimmedWord)).count();
    }

    private static void setUpDictionary(String[] book) {
        for (int i = 0; i < book.length; i++) {
            String nextWord = book[i].trim().toLowerCase();
            dictionary.merge(nextWord, 1, (oldValue, newValue) -> oldValue != null ? oldValue + newValue : newValue);
        }
    }

    private static int getFrequencies(String word) {
        return dictionary.getOrDefault(word.toLowerCase().trim(), 0);
    }


}
