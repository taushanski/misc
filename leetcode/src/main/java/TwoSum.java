import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {3, 5, -4, 8, 11, 1, -1, 6};
        int targetSum = 10;
        TwoSum twoSum = new TwoSum();
        System.out.println("twoSum.twoSum(nums, targetSum) = " + Arrays.toString(twoSum.twoSum(nums, targetSum)));

    }

    /*Time complexity is O(n) */
    public int[] twoSum(int[] nums, int targetSum) {
        int[] sumIndexes = new int[2];
        Map<Integer, Integer> helper = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            if (helper.containsKey(currentNumber)) { // we found the complementing number that has sum targetSum
                sumIndexes[0] = helper.get(currentNumber);
                sumIndexes[1] = i;
                return new int[]{helper.get(currentNumber), i};
            } else {
                int complementValue = targetSum - currentNumber;
                helper.put(complementValue, i);
            }
        }

        return sumIndexes;
    }

}
