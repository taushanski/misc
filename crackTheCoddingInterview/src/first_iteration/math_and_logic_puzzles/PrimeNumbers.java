package first_iteration.math_and_logic_puzzles;

public class PrimeNumbers {

    public static void main(String[] args) {
        boolean[] booleans = sieveOfEratosthenes(120);
        for (int i = 0; i < booleans.length; i++) {
            if (booleans[i]) {
                System.out.print(i + " ");
            }
        }
    }

    static boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }

        int numberSqrt = (int) Math.sqrt(number);
        for (int i = 2; i < numberSqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean[] sieveOfEratosthenes(int max) {
        boolean[] flags = new boolean[max + 1];

        int count = 0;

        init(flags); // Sets all flags to true except for 0 and 1

        int prime = 2;
        while (prime <= Math.sqrt(max)) {
            // Cross off the remining multiples of prime
            crossOff(flags, prime);
            // Find next value which is true
            prime = getNextPrimeNumber(flags, prime);
        }
        return flags;
    }

    private static void init(boolean[] flags) {
        for (int i = 2; i < flags.length; i++) {
            flags[i] = true;
        }
    }

    private static void crossOff(boolean[] flags, int prime) {
        /*
         * Cross off remaining multiples of prime. We can start with (prime*prime),
         * because if we have a k * prime, where k < prime, this value would have
         * already been crossed off in a prior iteration.
         * */

        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;

        }
    }

    private static int getNextPrimeNumber(boolean[] flags, int prime) {
        int next = prime + 1;
        while (next < flags.length && !flags[next]) {
            next++;
        }
        return next;
    }
}
