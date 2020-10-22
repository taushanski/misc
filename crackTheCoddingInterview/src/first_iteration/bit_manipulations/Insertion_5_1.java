package first_iteration.bit_manipulations;

public class Insertion_5_1 {

    public static void main(String[] args) {
        String nBinaryRepresentation = "10000000000";
        String mBinaryRepresentation = "10011";
        int i = 2;
        int j = 6;

        int n = Integer.valueOf(nBinaryRepresentation, 2);
        int m = Integer.valueOf(mBinaryRepresentation, 2);
        System.out.println("Integer.toBinaryString(-1) = " + Integer.toBinaryString(-1));
        System.out.println("n = " + n);
        System.out.println("m = " + m);

        int result = insert(n, m, j, i);
        System.out.println("Integer.toBinaryString(re) = " + Integer.toBinaryString(result));
    }

    private static int insert(int biggerNumber, int smallerNumber, int startPosition, int endPosition) {
        if (biggerNumber <= smallerNumber || startPosition - endPosition + 1 != Integer.toBinaryString(smallerNumber)
                                                                                       .length()) {
            throw new IllegalArgumentException();
        }
        int mask = -1 << (startPosition + 1);
        System.out.println("Integer.toBinaryString(mask) = " + Integer.toBinaryString(mask));
        mask = mask | ((1 << endPosition) - 1);
        System.out.println("Integer.toBinaryString(mask) = " + Integer.toBinaryString(mask));
        int result = biggerNumber & mask;
        System.out.println("Integer.toBinaryString(result) = " + Integer.toBinaryString(result));
        result = result | (smallerNumber << endPosition);
        return result;
    }
}
