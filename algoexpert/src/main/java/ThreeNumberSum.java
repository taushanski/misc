import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public static void main(String[] args) {
        int[] array = {12, 3, 1, 2, -6, 5, -8, 6};
        int targetSum = 0;
        List<Integer[]> triplets = threeNumberSum(array, targetSum);
        for (Integer[] nextTriplet : triplets) {
            System.out.println("Arrays.toString(nextTriplet) = " + Arrays.toString(nextTriplet));
        }
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> result = new ArrayList<Integer[]>();
        Arrays.sort(array);// O(nlog(n))
        for (int i = 0; i < array.length - 2; i++) { // O(n^2)
            int leftIndex = i + 1;
            int rightIndex = array.length - 1;
            while (leftIndex < rightIndex) {
                int tripletSum = array[i] + array[leftIndex] + array[rightIndex];
                if (tripletSum < targetSum) { // we have to increase the value by moving the left index
                    leftIndex++;
                } else if (tripletSum > targetSum) {// we have to decrease the value by moving the right index
                    rightIndex--;
                } else {
                    result.add(new Integer[]{array[i], array[leftIndex], array[rightIndex]});
                    leftIndex++;
                    rightIndex--;
                }
            }
        }

        return result;
    }
}
