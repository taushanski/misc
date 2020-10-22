import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {5, 8, 3, 12, 11, 18, 1, 3, 1};

        System.out.println("array = " + Arrays.toString(bubbleSort(array)));
    }

    /*Complexity: O(n^2) time | O(1) space . Best caseee time O(n)*/
    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
        return array;
    }

}
