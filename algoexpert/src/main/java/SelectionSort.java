import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {5, 8, 3, 12, 11, 18, 1, 3, 1};

        System.out.println("array = " + Arrays.toString(selectionSort(array)));
    }

    /*Complexity: O(n^2) time | O(1) space*/
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) { // this will represent the last index of the sorted subarray
            int minElementIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minElementIndex] > array[j]) {
                    minElementIndex = j;
                }
            }
            if (minElementIndex != i) { // there is smaller element we have to swap it
                swap(i, minElementIndex, array);
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
