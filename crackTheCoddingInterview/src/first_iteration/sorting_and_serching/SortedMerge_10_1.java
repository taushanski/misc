package first_iteration.sorting_and_serching;

import java.util.Arrays;

public class SortedMerge_10_1 {

    public static void main(String[] args) {
        int[] arrayA = {1, 3, 5, 7, 0, 0, 0, 0, 0};
        int[] arrayB = {2, 4, 6};
        sortedMerge(arrayA, arrayB, 4, 3);
        System.out.println("Arrays.toString(arrayA) = " + Arrays.toString(arrayA));

    }

    private static void sortedMerge(int[] a, int[] b, int sizeA, int sizeB) {
        int indexA = sizeA - 1;/* Index of last element in array a*/
        int indexB = sizeB - 1;/* Index of last element in array b*/
        int indexMerged = sizeA + sizeB - 1; /*end of merged array*/
        /* Merge a and b, starting from the last element in each*/
        while (indexA >= 0 && indexB >= 0 && indexMerged >= 0) {
            if (a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA];
                indexA--;
            } else {
                a[indexMerged] = b[indexB];
                indexB--;
            }
            indexMerged--;
        }
    }
}
