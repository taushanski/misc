public class MonotonicArray {

    public static void main(String[] args) {
        int[] array = {1, 1, -2, -3, -15, -15, -20};
        System.out.println("isMonotonic(array) = " + isMonotonic(array));

    }

    /*Complexity: O(n) time | O(1) space*/
    public static boolean isMonotonic(int[] array) {
        if (array.length < 2) {
            return true;
        }
        boolean isNonIncreasing = true;
        boolean isNonDecreasing = true;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                isNonIncreasing = false;
            }
            if (array[i] > array[i + 1]) {
                isNonDecreasing = false;
            }

        }
        return isNonDecreasing || isNonIncreasing;
    }

}
