import java.util.Arrays;

public class FindThreeLargestNumbers {

    public static void main(String[] args) {
        int[] numbers = {-2, -1, 7};
        System.out.println("findThreeLargestNumbers(numbers) = " + Arrays.toString(findThreeLargestNumbers(numbers)));

    }

    /*complexity: O(n) time| O(1)*/
    private static int[] findThreeLargestNumbers(int[] numbers) {
        if (numbers.length < 3) {
            throw new IllegalArgumentException();
        }
        int[] result = new int[3];
        Arrays.fill(result, Integer.MIN_VALUE);
        for (int i = 0; i < numbers.length; i++) {
            int nextNumber = numbers[i];
            storeNextBiggestNumber(result, nextNumber);
        }
        return result;
    }

    private static void storeNextBiggestNumber(int[] result, int nextNumber) {
        if (nextNumber >= result[2]) {
            result[0] = result[1];
            result[1] = result[2];
            result[2] = nextNumber;
        } else if (nextNumber >= result[1]) {
            result[0] = result[1];
            result[1] = nextNumber;
        } else if (nextNumber >= result[0]) {
            result[0] = nextNumber;
        }
    }
}
