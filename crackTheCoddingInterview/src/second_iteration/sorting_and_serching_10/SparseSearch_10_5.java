package second_iteration.sorting_and_serching_10;

public class SparseSearch_10_5 {

    public static void main(String[] args) {
        String[] strings = {"at", "", "", "", "ball", "", "", "", "cat", "", "", "hat", "that", "", "uber"};
        String searchString = "hat";
        System.out.println("search(searchString) = " + search(strings, searchString));

    }

    // a modification of the binary search algorithm
    private static int search(String[] words, String word) {
        if (words == null || word == null || word == "") {
            return -1;
        }
        return search(words, word, 0, words.length - 1);
    }

    private static int search(String[] words, String word, int first, int last) {
        if (first > last) {
            return -1;
        }

        int middle = (first + last) / 2;

        // in case middle element is an empty string find the closest non null string
        if (words[middle] == "") {
            int left = middle - 1;
            int right = middle + 1;
            while (true) {
                if (left < first && right > last) {
                    return -1;
                } else if (right <= last && !words[right].isEmpty()) {
                    middle = right;
                    break;
                } else if (left >= first && !words[left].isEmpty()) {
                    middle = left;
                    break;
                }
                left--;
                right++;
            }
        }

        if (word.equals(words[middle])) {
            return middle;
        } else if (word.compareTo(words[middle]) < 0) { // on the left side
            return search(words, word, first, middle - 1);
        } else {
            return search(words, word, middle + 1, last);
        }


    }

}
