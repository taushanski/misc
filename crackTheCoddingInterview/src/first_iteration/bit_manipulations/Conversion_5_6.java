package first_iteration.bit_manipulations;

public class Conversion_5_6 {
    public static void main(String[] args) {
        int a = Integer.valueOf("11101", 2);
        int b = Integer.valueOf("01111", 2);

        System.out.printf("%d number of bit swaps required to convert %d to %d", bitSwapRequired(a, b), a, b);

        Integer aa = Integer.valueOf("aa", 16);
        System.out.println("Integer.valueOf(\"aa\", 16) = " + aa);
        System.out.println("Integer.valueOf(\"aa\", 16) to binary = " + Integer.toBinaryString(aa));
        System.out.println("Integer.toBinaryString(0xaaaaaaaa) = " + Integer.toBinaryString(0xaaaaaaaa));

    }

    private static int bitSwapRequired(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c >>= 1) {
            count += c & 1;
        }
        return count;
    }
}
