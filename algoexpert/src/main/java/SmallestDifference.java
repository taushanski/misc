import java.util.Arrays;

public class SmallestDifference {

    public static void main(String[] args) {
        int[] left = {-1, 5, 10, 20, 28, 3};
        int[] right = {26, 134, 135, 15, 17};

        System.out.println("Arrays.toString(smallestDifference(left, right)) = " + Arrays.toString(
                smallestDifference(left, right)));
    }


    /*O(nlog(n) + mlog(m)) time| O(log(n) + log(m) space)*/
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // first we have to sort the arrays
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int[] smallestPair = new int[2];
        int smallestDistance = Integer.MAX_VALUE;
        int leftPointer = 0;
        int rightPointer = 0;
        int currentDistance;
        while (leftPointer < arrayOne.length && rightPointer < arrayTwo.length) {
            int firstNumber = arrayOne[leftPointer];
            int secondNumber = arrayTwo[rightPointer];
            if (firstNumber > secondNumber) {
                currentDistance = firstNumber - secondNumber;
                rightPointer++;
            } else if (firstNumber < secondNumber) {
                currentDistance = secondNumber - firstNumber;
                leftPointer++;
            } else {
                smallestPair[0] = firstNumber;
                smallestPair[1] = secondNumber;
                break;
            }
            if (currentDistance < smallestDistance) {
                smallestDistance = currentDistance;
                smallestPair[0] = firstNumber;
                smallestPair[1] = secondNumber;
            }
        }
        return smallestPair;
    }


}
