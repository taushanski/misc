import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {5, 8, 3, 12, 11, 18, 1, 3, 1};

        System.out.println("array = " + Arrays.toString(quickSort(array)));
    }

    /*Complexity: O(nlog(n)) time | O(log(n) space)*/
    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private static void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) { // base case
            return;
        }
        int pivotIndex = startIndex;
        int leftIndex = pivotIndex + 1;
        int rightIndex = endIndex;
        while (rightIndex >= leftIndex) {
            if (array[leftIndex] > array[pivotIndex] && array[rightIndex] < array[pivotIndex]) { // this means that
                // we have to swap left and right as they are not in the correct ordeer in respect to the pivot
                swap(leftIndex, rightIndex, array);
                leftIndex++;
                rightIndex--;
            }
            if (array[leftIndex] <= array[pivotIndex]) {
                leftIndex++;
            }
            if (array[rightIndex] >= array[pivotIndex]) {
                rightIndex--;
            }
        }
        // we reached a point where the right and the pivot have to be switched
        swap(pivotIndex, rightIndex, array);
        // we have to sort the remaining two subarrays starting with the smaller one
        boolean isLeftSmaller = rightIndex - 1 - startIndex < endIndex - rightIndex + 1;
        if (isLeftSmaller) {
            quickSort(array, startIndex, rightIndex - 1);
            quickSort(array, rightIndex + 1, endIndex);
        } else {
            quickSort(array, rightIndex + 1, endIndex);
            quickSort(array, startIndex, rightIndex - 1);
        }
    }

    private static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
