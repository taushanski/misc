import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {5, 8, 3, 12, 11, 18, 1, 3, 1};

        System.out.println("array = " + Arrays.toString(mergeSort(array)));
    }

    /*Complexity: O(nlog(n)) time| O(n) space*/
    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int[] auxiliaryArray = Arrays.copyOf(array, array.length);
        mergeSortHelper(array, 0, array.length - 1, auxiliaryArray);
        return array;
    }

    private static void mergeSortHelper(int[] mainArray, int startIndex, int endIndex, int[] auxiliaryArray) {
        if (startIndex == endIndex) {
            return; // nothing to do already sorted
        }
        int middleIndex = (startIndex + endIndex) / 2;
        mergeSortHelper(auxiliaryArray, startIndex, middleIndex, mainArray);
        mergeSortHelper(auxiliaryArray, middleIndex + 1, endIndex, mainArray);
        mergeSortedArrays(mainArray, startIndex, middleIndex, endIndex, auxiliaryArray); // at this point we will
        // have both halves of the auxiliaryArray sorted so we merge them in the main array
    }

    private static void mergeSortedArrays(int[] mainArray, int startIndex, int middleIndex, int endIndex, int[] auxiliaryArray) {
        int mergedArrayIndex = startIndex;
        int leftSubarrayIndex = startIndex;
        int rightSubarrayIndex = middleIndex + 1;
        while (leftSubarrayIndex <= middleIndex && rightSubarrayIndex <= endIndex) {
            if (auxiliaryArray[leftSubarrayIndex] <= auxiliaryArray[rightSubarrayIndex]) {
                mainArray[mergedArrayIndex] = auxiliaryArray[leftSubarrayIndex];
                leftSubarrayIndex++;
            } else {
                mainArray[mergedArrayIndex] = auxiliaryArray[rightSubarrayIndex];
                rightSubarrayIndex++;
            }
            mergedArrayIndex++;
        }
        // copy what's left of left subarray and right subarray respectivelly
        while (leftSubarrayIndex <= middleIndex) {
            mainArray[mergedArrayIndex++] = auxiliaryArray[leftSubarrayIndex++];
        }
        while (rightSubarrayIndex <= endIndex) {
            mainArray[mergedArrayIndex++] = auxiliaryArray[rightSubarrayIndex++];
        }
    }

}
