package first_iteration.sorting_and_serching;

import java.util.Arrays;

public class SortingAlgorithms {
    public static void main(String[] args) {
        {
            int[] elements = {5, 1, 8, 10, 2};
            bubbleSort(elements);
            System.out.println("The bubble sorted elements: " + Arrays.toString(elements));
        }
        {
            int[] elements = {5, 1, 8, 10, 2};
            selectionSort(elements);
            System.out.println("The selection sorted elements: " + Arrays.toString(elements));
        }
        {
            int[] elements = {5, 1, 8, 10, 2};
            mergeSort(elements);
            System.out.println("The merge sorted elements: " + Arrays.toString(elements));
        }
        {
            int[] elements = {5, 1, 8, 10, 2};
            quickSort(elements, 0, elements.length - 1);
            System.out.println("The quick sorted elements: " + Arrays.toString(elements));
        }
    }

    /*In bubble sort, we start at the beginning of the array and swap the first two elements if the first is greater than the second.
     Then, we go to the next pair, and so on, continuously making sweeps of the array until it is sorted.
     In doing so, the smaller items slowly"bubble" up to the beginning of the list.
     The runtime is O(n^2) and the space is O(1). Runtime: 0( n^2 ) average and worst case. Memory: 0( 1) .
*/
    public static void bubbleSort(int[] elements) {
        for (int i = 0; i < elements.length - 1; i++) {
            for (int j = 0; j < elements.length - i - 1; j++) {
                if (elements[j] > elements[j + 1]) {
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    /*SelectionSortIRuntime: 0(n2)averageandworstcase.Memory:0(1).
    Selection sort is the child's algorithm: simple, but inefficient. Find the smallest element using a linear scan and move it to the front
    (swapping it with the front element). Then, find the second smallest and move it, again doing a linear scan.
    Continue doing this until all the elements are in place.*/
    public static void selectionSort(int[] elements) {
        int minElementIndex = 0;
        for (int i = 0; i < elements.length - 1; i++) {
            minElementIndex = i;
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[minElementIndex] > elements[j]) {
                    minElementIndex = j;
                }
            }
            if (minElementIndex != i) { // swap the elements if there is smaller element  exists
                int temp = elements[i];
                elements[i] = elements[minElementIndex];
                elements[minElementIndex] = temp;
            }
        }
    }

    /*Merge Sort I Runtime: 0 ( n log ( n)) average and worst case. Memory: Depends.
     Merge sort divides the array in half, sorts each of those halves, and then merges them back together.
     Each of those halves has the same sorting algorithm applied to it. Eventually, you are merging just two single­ element arrays.
     It is the "merge" part that does all the heavy lifting.
      The merge method operates by copying all the elements from the target array segment into a helper array,
      keeping track of where the start of the left and right halves should be (helperleft and helperRight).
      We then iterate through helper, copying the smaller element from each half into the array.
      At the end, we copy any remaining elements into the target array.
    The space complexity is 0(n)

     */
    public static void mergeSort(int[] elements) {
        int[] helper = new int[elements.length];
        mergeSort(elements, helper, 0, elements.length - 1);
    }

    private static void mergeSort(int[] elements, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(elements, helper, low, middle);// sort the left part
            mergeSort(elements, helper, middle + 1, high);// sort the right part
            merge(elements, helper, low, middle, high);// merge them

        }
    }

    private static void merge(int[] elements, int[] helper, int low, int middle, int high) {
        /*Copy both halves into a helper array*/
        for (int i = low; i <= high; i++) {
            helper[i] = elements[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        /*Iterate through helper array. Compare the left and right half, copying back
         * the smaller element from the two halves into the original array*/
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {//
                elements[current] = helper[helperLeft];
                helperLeft++;
            } else { // if right element is smaller than the left
                elements[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        /*Copy the rest of the left side of the array into the target array*/
        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            elements[current + i] = helper[helperLeft + i];
        }
    }

    /*
     * Quick Sort I Runtime: O(n log(n)) average, O(n2 ) worst case. Memory: 0( log(n)).
     * In quick sort we pick a random element and partition the array, such that all numbers that are
     * less than the partitioning element come before all elements that are greater than it.
     * The partitioning can be performed efficiently through a series of swaps (see below).
     * If we repeatedly partition the array (and its sub-arrays) around an element, the array will eventually become sorted.
     * However, as the partitioned element is not guaranteed to be the median (or anywhere near the median), our sorting could be very slow.
     * This is the reason for the 0(n2) worst case runtime.
     */
    public static void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) {
            quickSort(arr, left, index - 1); // sort the left half
        }
        if (index < right) {
            quickSort(arr, index, right); // sort the right half

        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];// Pick pivot point

        while (left <= right) {
            //Find element that should be on the right
            while (arr[left] < pivot) {
                left++;
            }

            // Find element that should be on the left
            while (arr[right] > pivot) {
                right--;
            }
            //Swap elements, and move left and right indices
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}

