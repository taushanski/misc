package second_iteration.recursion_and_dinamic_programing_8;

import java.util.Arrays;

public class TripleSteps_8_1 {

    public static void main(String[] args) {
        int steps = 35;
        System.out.println("climbSteps(steps) = " + climbSteps(steps));
        System.out.println("climbStepsMemoization(steps) = " + climbStepsMemoization(steps));
    }

    // O(3^n)
    private static int climbSteps(int steps) {
        if (steps < 0) { // base case
            return 0;
        } else if (steps == 0) {
            return 1;
        }
        return climbSteps(steps - 1) + climbSteps(steps - 2) + climbSteps(steps - 3);
    }

    private static int climbStepsMemoization(int steps) {
        int[] memo = new int[steps + 1];
        Arrays.fill(memo, -1);
        return climbStepsMemoization(steps, memo);
    }

    private static int climbStepsMemoization(int steps, int[] memo) {
        if (steps < 0) {
            return 0;
        } else if (steps == 0) {
            return 1;
        } else if (memo[steps] > -1) {
            return memo[steps];
        } else {
            memo[steps] = climbStepsMemoization(steps - 1, memo) +
                    climbStepsMemoization(steps - 2, memo) +
                    climbStepsMemoization(steps - 3, memo);
            return memo[steps];
        }
    }
}
