public class BinarySearch {

    public static void main(String[] args) {
        int[] numbers = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        int targetNumber = 72;
        System.out.println("binarySearch(numbers, targetNumber) = " + binarySearchRecursive(numbers, targetNumber));
        System.out.println("binarySearch(numbers, targetNumber) = " + binarySearchIterative(numbers, targetNumber));

    }

    /*Complexity: O(log(n)) time | O(1) space*/
    private static int binarySearchIterative(int[] numbers, int targetNumber) {
        int startIndex = 0;
        int endIndex = numbers.length - 1;
        int middleIndex;
        while (startIndex < endIndex) {
            middleIndex = (startIndex + endIndex) / 2;
            if (targetNumber < numbers[middleIndex]) {
                endIndex = middleIndex - 1;
            } else if (targetNumber > numbers[middleIndex]) {
                startIndex = middleIndex + 1;
            } else {
                return middleIndex;
            }
        }

        return -1;
    }

    /*O(log(n)) time | O(log(n)) space*/
    private static int binarySearchRecursive(int[] numbers, int targetNumber) {
        if (numbers.length == 0) {
            return -1;
        }
        return binarySearchHelper(numbers, targetNumber, 0, numbers.length - 1);
    }

    private static int binarySearchHelper(int[] numbers, int targetNumber, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }
        int middleIndex = (startIndex + endIndex) / 2;
        if (targetNumber < numbers[middleIndex]) {
            return binarySearchHelper(numbers, targetNumber, startIndex, middleIndex - 1);
        } else if (targetNumber > numbers[middleIndex]) {
            return binarySearchHelper(numbers, targetNumber, middleIndex + 1, endIndex);
        } else {
            return middleIndex;
        }
    }
}
