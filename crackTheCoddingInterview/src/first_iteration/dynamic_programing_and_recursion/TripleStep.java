package first_iteration.dynamic_programing_and_recursion;

import java.util.Arrays;

public class TripleStep {

    public static void main(String[] args) {
        int stepCount = 100;
        long startTime = System.currentTimeMillis();
        //        System.out.println("countWays(stepCount) = " + countWays(stepCount));
        //        System.out.println("Execution time ms = " + (System.currentTimeMillis() - startTime));
        //
        System.out.println("countWaysWithMemorization(stepCount) = " + countWaysWithMemorization(stepCount));

        System.out.println("Execution time ms = " + (System.currentTimeMillis() - startTime));
    }

    private static long countWays(int stepCount) {
        if (stepCount < 0) {
            return 0;
        } else if (stepCount == 0) {
            return 1;
        } else {
            return countWays(stepCount - 1) + countWays(stepCount - 2) + countWays(stepCount - 3);
        }
    }

    private static long countWaysWithMemorization(int stepCount) {
        long[] memo = new long[stepCount + 1];
        Arrays.fill(memo, -1);
        return countWaysWithMemorization(stepCount, memo);
    }

    private static long countWaysWithMemorization(int stepCount, long[] memo) {
        if (stepCount < 0) {
            return 0;
        } else if (stepCount == 0) {
            return 1;
        } else if (memo[stepCount] > -1) {
            return memo[stepCount];
        } else {
            memo[stepCount] = countWaysWithMemorization(stepCount - 1, memo) + countWaysWithMemorization(stepCount - 2,
                    memo) + countWaysWithMemorization(stepCount - 3, memo);
            return memo[stepCount];
        }
    }
}
