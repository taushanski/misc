package second_iteration.sorting_and_serching_10;

import java.util.*;

public class GroupAnagrams_10_2 {


    static void sort(String[] words) {
        Map<String, List<String>> mapList = new HashMap<>();

        /*Group words by anagram*/
        for (String word : words) {
            String key = sortChars(word);
            mapList.compute(key, (s, strings) -> {
                List<String> result = strings == null ? new ArrayList<>() : strings;
                strings.add(word);
                return result;
            });
        }
        /*convert hashtable to array*/
        int index = 0;
        for (String key : mapList.keySet()) {
            List<String> anagrams = mapList.get(key);
            for (String anagram : anagrams) {
                words[index] = anagram;
                index++;
            }
        }

    }

    private static String sortChars(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
