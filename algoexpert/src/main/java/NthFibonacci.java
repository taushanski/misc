public class NthFibonacci {

    public static void main(String[] args) {
        int n = 0;
        System.out.println("getFibonacci(n) = " + getNthFibNonOptimized(n));
        System.out.println("getFibonacci(n) = " + getNthFibOptimized(n));
    }

    // Non optimized: O(2^N) time | O(N) space
    private static int getNthFibNonOptimized(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return getNthFibNonOptimized(n - 1) + getNthFibNonOptimized(n - 2);
    }

    /*O(n) time | O(1) space*/
    public static int getNthFibOptimized(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int a = 0;
        int b = 1;
        for (int i = 2; i < n - 1; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a + b;
    }

}
