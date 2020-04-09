package sorting_and_serching;

public class SparseSearch_10_5 {
    // Worst case runtime for this solution is O(n). Average case is O(log n)
    public static void main(String[] args) {
        String[] input = {"", "", "", "", "", "aha", "", "baha", "", "", "", "", "", "", "dad", "", "", ""};
        String searchFor = "dad";
        System.out.printf("iterative: The index of: {%s} is %d%n", searchFor, findString(input, searchFor));
        System.out.printf("recursive: The index of: {%s} is %d%n", searchFor, findStringRecursive(input, searchFor));
    }

    private static int findString(String[] input, String searchFor) {
        int low = 0;
        int high = input.length;
        int middle;
        while (low < high) {
            middle = (low + high) / 2;
            String middleElement = input[middle];
            if (searchFor.compareTo(middleElement) == 0) {
                return middle;
            } else if (middleElement.equals("")) {
                // compare with the first non empty element on the left
                int i = middle - 1;
                for (; i > low; i--) {
                    String temp = input[i];
                    if (temp.equals("")) {
                        continue;
                    } else if (temp.equals(searchFor)) {
                        return i;
                    } else if (searchFor.compareTo(temp) < 0) { // its on the left of i
                        high = i - 1;
                        break;
                    } else if (searchFor.compareTo(temp) > 0) {// its on the right of i
                        low = middle + 1;
                    }
                }
                if (i == low) { // there are no non empty elements on the left
                    low = middle + 1;
                }

            } else if (searchFor.compareTo(middleElement) < 0) { // its on the left
                high = middle - 1;
            } else if (searchFor.compareTo(middleElement) > 0) { // its on the right
                low = middle + 1;
            }
        }

        return -1;
    }

    private static int findStringRecursive(String[] strings, String searchFor) {
        if (strings == null || searchFor == null || searchFor.equals("")) {
            return -1;
        }
        return findStringRecursive(strings, searchFor, 0, strings.length - 1);
    }

    private static int findStringRecursive(String[] strings, String searchFor, int first, int last) {
        if (first > last) {
            return -1;
        }

        int middle = (first + last) / 2;


        if (strings[middle].isEmpty()) { // compare with the nearest non empty string
            int left = middle - 1;
            int right = middle + 1;
            while (left >= first && right <= last) {

                if (!strings[right].isEmpty()) {
                    middle = right;
                    break;
                } else if (!strings[left].isEmpty()) {
                    middle = left;
                    break;
                }
                right++;
                left--;

            }
        }

        String middleElement = strings[middle];

        if (searchFor.equals(middleElement)) {
            return middle;
        } else if (searchFor.compareTo(middleElement) < 0) { // on the left side
            return findStringRecursive(strings, searchFor, first, middle - 1);
        } else { // on the right side
            return findStringRecursive(strings, searchFor, middle + 1, last);
        }
    }
}
