package second_iteration.recursion_and_dinamic_programing_8;

public class FibonacciNumbers {

    public static void main(String[] args) {
        int number = 5000;
//        System.out.println("computeFibonacci(number) = " + computeFibonacciNonOptimized(number));
        System.out.println("fibonacciBottomUp(number*1000) = " + fibonacciBottomUp(number));
        System.out.println("fibonacciOptimized(number*1000) = " + fibonacciOptimized(number));
        System.out.println("fibonacciBottomUpReducedMemory(number*1000) = " + fibonacciBottomUpReducedMemory(number));
    }

    // O(2^n)
    private static int computeFibonacciNonOptimized(int number) {
        if (number == 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        return computeFibonacciNonOptimized(number - 1) + computeFibonacciNonOptimized(number - 2);
    }

    // O(2n) -> O(n)
    private static long fibonacciOptimized(int number) {
        return fibonacciOptimized(number, new long[number + 1]);
    }

    private static long fibonacciOptimized(int number, long[] cache) {
        if (number == 0 || number == 1) {
            return number;
        }

        if (cache[number] == 0) {
            cache[number] = fibonacciOptimized(number - 1, cache) + fibonacciOptimized(number - 2, cache);
        }
        return cache[number];
    }

    /*runtime O(n), memory O(n)*/
    private static long fibonacciBottomUp(int number) {
        if (number == 0 || number == 1) {
            return number;
        }

        long[] cache = new long[number];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i < number; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[number - 1] + cache[number - 2];
    }

    /*runtime O(n), memory O(1)*/
    private static long fibonacciBottomUpReducedMemory(int number) {
        if (number == 0 || number == 1) {
            return number;
        }

        long a = 0;
        long b = 1;
        for (int i = 2; i < number; i++) {
            long c = a + b;
            a = b;
            b = c;
        }
        return a + b;
    }


}
