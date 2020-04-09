package threads;

public class FizzBuzz_15_7 {
    public static void main(String[] args) {
        fizzBuzz(10);
    }

    static void fizzBuzz(int n) {
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    private static class FizzBuzzThread extends Thread {
        private static Object lock = new Object();
        protected static int current = 1;
        private int max;
        private boolean div3;
        private boolean div5;

        private String toPrint;

        public FizzBuzzThread(boolean div3, boolean div5, int max, String toPrint) {
            this.max = max;
            this.div3 = div3;
            this.div5 = div5;
            this.toPrint = toPrint;
        }

        public void print() {
            System.out.println(toPrint);
        }
    }

}
