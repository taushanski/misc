package second_iteration.sorting_and_serching_10;

import java.util.Arrays;

public class SortingAlgorithms {

    public static void main(String[] args) {
        {
            int[] arr = {64, 34, 25, 12, 22, 11, 90};
            bubbleSort(arr);
            System.out.println("bubbleSortedArr  = " + Arrays.toString(arr));
        }
        {
            int[] arr = {64, 34, 25, 12, 22, 11, 90};
            selectionSort(arr);
            System.out.println("selectionSort  = " + Arrays.toString(arr));
        }
        {
            int[] arr = {64, 34, 25, 12, 22, 11, 90};
            mergeSort(arr);
            System.out.println("mergeSort  = " + Arrays.toString(arr));
        }
        {
            int[] arr = {64, 34, 25, 12, 22, 11, 90};
            quickSort(arr);
            System.out.println("quickSort = " + Arrays.toString(arr));
        }
    }

    /*Bubble Sort I Runtime: 0( n2 ) average and worst case. Memory: 0( 1) .
     * In bubble sort, we start at the beginning of the array and swap the first two elements if the first is greater
     * than the second. Then, we go to the next pair, and so on, continuously making sweeps of the array until
     *  it is sorted. In doing so, the smaller items slowly"bubble" up to the beginning of the list.
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    /*
     * SelectionSortIRuntime: 0(n2)averageandworstcase.Memory:0(1).
     * Selection sort is the child's algorithm: simple, but inefficient.
     * Find the smallest element using a linear scan and move it to the front
     * (swapping it with the front element). Then, find the second smallest and move it, again doing a linear scan.
     *  Continue doing this until all the elements are in place.
     * */

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            // find the min index
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first
            // element
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    /*
     * Merge Sort I Runtime: 0 ( n log ( n)) average and worst case. Memory: Depends.
     * Merge sort divides the array in half, sorts each of those halves, and then merges them back together.
     * Each of those halves has the same sorting algorithm applied to it. Eventually, you are merging just two single element arrays.
     * It is the "merge" part that does all the heavy lifting. The space complexity of merge sort is 0(n) due to the auxiliary space used to merge parts of the array.*/

    public static void mergeSort(int[] arr) {
        int[] helper = new int[arr.length];
        mergeSort(arr, helper, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(arr, helper, low, middle);
            mergeSort(arr, helper, middle + 1, high);
            merge(arr, helper, low, middle, high);
        }
    }

    private static void merge(int[] arr, int[] helper, int low, int middle, int high) {
        // copy the elements in the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = arr[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        /** Iterate through helper array. Compare the left and right half, copying back
         * the smaller element from the two halves into the original array.*/
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                arr[current] = helper[helperLeft];
                helperLeft++;
            } else { // if right element is smaller than the left
                arr[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        // copy the remaining elements from the left side
        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            arr[current + i] = helper[helperLeft + i];
        }

    }

    /*Quick Sort I Runtime: O(n log(n)) average, O(n2 ) worst case. Memory: 0( log(n)).
    In quick sort we pick a random element and partition the array, such that all numbers
    that are less than the partitioning element come before all elements that are greater than it.
    The partitioning can be performed efficiently through a series of swaps (see below).
    If we repeatedly partition the array (and its sub-arrays) around an element,
    the array will eventually become sorted. However, as the partitioned element is not guaranteed to be the
    median (or anywhere near the median), our sorting could be very slow.
    This is the reason for the 0(n2) worst case runtime.*/
    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) { // sort left half
            quickSort(arr, left, index - 1);
        }
        if (index < right) { // sort right half
            quickSort(arr, index, right);

        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        while (left <= right) {
            // find the element that should be on the right
            while (arr[left] < pivot) {
                left++;
            }
            // Find element on right that should be on left
            while (arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }

}
