package first_iteration.sorting_and_serching;

public class Searching {

    public static void main(String[] args) {
        int[] elements = {1, 5, 6, 7, 8, 20};
        System.out.println("binarySearch(elements, 7) = " + binarySearch(elements, 7));
        System.out.println("binarySearchRecursive(elements, 7, 0, elements.length-1) = " + binarySearchRecursive(elements, 7, 0, elements.length-1));
    }

    /*In binary search, we look for an element xin a sorted array by first comparing xto the midpoint of the array.
     *If x is less than the midpoint, then we search the left half of the array. If xis greater than the midpoint,
     *then we search the right half of the array. We then repeat this process, treating the left and right halves as subar­ rays.
     *Again, we compare xto the midpoint of this subarray and then search either its left or right side.
     *We repeat this process until we either find x or the subarray has size 0.
     * Runtime O(log(n)) space O(1)
     * */
    public static int binarySearch(int[] elements, int x) {
        int low = 0;
        int high = elements.length - 1;
        int middle;
        while (low <= high) {
            middle = (low + high) / 2;
            if (elements[middle] < x) { // we have to check in the right subarray
                low = middle + 1;
            } else if (elements[middle] > x) { // we have to check in the left subarray
                high = middle - 1;
            } else { // we found the element
                return middle;
            }
        }
        return -1; // not found
    }

    public static int binarySearchRecursive(int[] elements, int x, int low, int high) {
        if (low > high) {
            return -1;
        }
        int middle = (low + high) / 2;
        if (elements[middle] < x) { // its in the right subarray
            return binarySearchRecursive(elements, x, middle + 1, high);
        } else if (elements[middle] > x) { // its in the left subarray
            return binarySearchRecursive(elements, x, 0, middle - 1);
        } else {
            return middle;
        }
    }
}
