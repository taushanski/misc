import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {5, 8, 3, 12, 11, 18, 1, 3, 1};

        System.out.println("array = " + Arrays.toString(insertionSort(array)));
    }

    /* Complexity: O(n^2) time | O(1) space*/
    public static int[] insertionSort(int[] array) {
        if (array.length < 2) {
            return array; // if its empty or with single element we can consider it already sorted
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                swap(j, j - 1, array);
            }
        }
        return array;
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
