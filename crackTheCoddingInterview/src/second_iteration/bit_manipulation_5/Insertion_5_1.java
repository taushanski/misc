package second_iteration.bit_manipulation_5;

public class Insertion_5_1 {

    public static void main(String[] args) {
        int n = Integer.parseInt("10000010001", 2);
        int m = Integer.parseInt("10011", 2);
        int i = 2;
        int j = 6;
        System.out.println("insert(n,m,i,j) = " + insert(n, m, i, j));

    }

    private static String insert(int n, int m, int i, int j) {
        int mask = ~(((1 << (j - i + 1)) - 1) << i); // 11110000011
        System.out.println("Integer.toBinaryString(mask) = " + Integer.toBinaryString(mask));
        int result = (n & mask) | (m << i);
        System.out.println("Integer.toBinaryString(result) = " + Integer.toBinaryString(result));
        return Integer.toBinaryString(result);
    }

}
