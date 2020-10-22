package second_iteration.sorting_and_serching_10;

import java.util.Arrays;

public class SortedMerge_10_1 {

    public static void main(String[] args) {
        int[] leftArray = {10, 15, 20, 25, 0, 0, 0, 0};
        int[] rightArray = {11, 21, 24, 26};
        merge(leftArray, rightArray);
        System.out.println("leftArray = " + Arrays.toString(leftArray));
    }

    private static void merge(int[] leftArray, int[] rightArray) {
        int leftArrayIndex = leftArray.length - rightArray.length -1;
        int rightArrayIndex = rightArray.length - 1;
        int leftArrayInsertionIndex = leftArray.length - 1;
        while (rightArrayIndex >= 0) {
            if (leftArrayIndex >= 0 && leftArray[leftArrayIndex] > rightArray[rightArrayIndex]) {
                leftArray[leftArrayInsertionIndex] = leftArray[leftArrayIndex];
                leftArrayIndex--;
            } else {
                leftArray[leftArrayInsertionIndex] = rightArray[rightArrayIndex];
                rightArrayIndex--;
            }
            leftArrayInsertionIndex--;
        }

    }

}
