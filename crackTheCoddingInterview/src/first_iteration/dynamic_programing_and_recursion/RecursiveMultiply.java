package first_iteration.dynamic_programing_and_recursion;

public class RecursiveMultiply {

    public static void main(String[] args) {
        int x = 100123400;
        int y = 1019092345;
        {
            long startTime = System.currentTimeMillis();
            System.out.println("multiplyIterative(" + x + "," + y + ")= " + multiplyIterative(x, y));
            System.out.printf("it took %d ms time%n ", (System.currentTimeMillis() - startTime));
        }
        {
            long startTime = System.currentTimeMillis();
            System.out.println("multiplyRecursive(" + x + "," + y + ")= " + multiplyRecursive(x, y));
            System.out.printf("it took %d ms time%n ", (System.currentTimeMillis() - startTime));
        }
        {
            long startTime = System.currentTimeMillis();
            System.out.println("minProduct(" + x + "," + y + ")= " + minProduct(x, y));
            System.out.printf("it took %d ms time%n ", (System.currentTimeMillis() - startTime));
        }
        {
            long startTime = System.currentTimeMillis();
            System.out.println("minProductOptimized(" + x + "," + y + ")= " + minProductOptimized(x, y));
            System.out.printf("it took %d ms time%n ", (System.currentTimeMillis() - startTime));
        }
        {
            long startTime = System.currentTimeMillis();
            System.out.println(
                    "minProductFinalOptimization(" + x + "," + y + ")= " + minProductFinalOptimization(x, y));
            System.out.printf("it took %d ms time %n", (System.currentTimeMillis() - startTime));
        }
    }

    private static int multiplyIterative(int x, int y) {
        int smaller = x < y ? x : y;
        int bigger = x < y ? y : x;
        int result = bigger;
        for (int i = 1; i < smaller; i++) {
            result += bigger;
        }
        return result;
    }

    /*The runtime is O(min(x,y))*/
    private static int multiplyRecursive(int x, int y) {
        int min = x < y ? x : y;
        int max = x < y ? y : x;
        return multiplyRecursiveImpl(min, max);
    }

    private static int multiplyRecursiveImpl(int min, int max) {
        if (min <= 0) {
            return 0;
        }
        return max + multiplyRecursiveImpl(--min, max);
    }

    private static int minProduct(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;

        return minProductHelper(bigger, smaller);
    }

    private static int minProductHelper(int bigger, int smaller) {
        if (smaller == 0) { // 0*something ==0
            return 0;
        } else if (smaller == 1) { // 1* something  == something
            return bigger;
        }

        /*Compute half. If uneven, compute the other half and sum it otherwise just double it */
        int s = smaller >> 1; // Divide by 2
        int side1 = minProduct(s, bigger);
        int side2 = side1;
        // check if its odd
        if (smaller % 2 == 1) {
            side2 = minProduct(smaller - s, bigger);
        }

        return side1 + side2;
    }

    private static int minProductOptimized(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;
        int[] memo = new int[smaller + 1];
        return minProductOptimized(bigger, smaller, memo);
    }

    private static int minProductOptimized(int bigger, int smaller, int[] memo) {
        if (smaller == 0) { // 0*something ==0
            return 0;
        } else if (smaller == 1) { // 1* something  == something
            return bigger;
        } else if (memo[smaller] > 0) {
            return memo[smaller];
        }

        /*Compute half. If uneven, compute the other half and sum it otherwise just double it */
        int s = smaller >> 1; // Divide by 2
        int side1 = minProduct(s, bigger);
        int side2 = side1;
        // check if its odd
        if (smaller % 2 == 1) {
            side2 = minProduct(smaller - s, bigger);
        }
        /* Sum and cache.*/
        memo[smaller] = side1 + side2;
        return memo[smaller];

    }

    /*
    * This is unnecessary. Instead, we can do:
            minProduct(31, 35) = 2 * minProduct(15, 35) + 35 After all, since 31 = 2*15+1, then 31x35 = 2*15*35+35.
    * The logic in this final solution is that, on even numbers, we just divide smaller by 2 and double the result of the recursive call.
    * On odd numbers, we do the same, but then we also add b igger to this result.
    * */
    // this works in O(logs) where s is the min(a, b)
    private static int minProductFinalOptimization(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;
        return minProductFinalOptimizationHelper(smaller, bigger);
    }

    private static int minProductFinalOptimizationHelper(int smaller, int bigger) {
        if (smaller == 0) { // 0*something ==0
            return 0;
        } else if (smaller == 1) { // 1* something  == something
            return bigger;
        }

        int s = smaller >> 1; // Divide by 2
        int halfProduct = minProductFinalOptimizationHelper(s, bigger);
        if (smaller % 2 == 0) { // its an even number so we can just double the result
            return halfProduct + halfProduct;
        } else {
            return halfProduct + halfProduct + bigger;
        }
    }

}
