package first_iteration.bit_manipulations;

public class BitsExample {
    public static void main(String[] args) {
        int x = -75;
        int count = 1;
        System.out.printf("repeatedArithmeticShift result: %d%n", repeatedArithmeticShift(x, count));
        System.out.printf("repeatedLogicalShift result: %d%n", repeatedLogicalShift(x, count));


        System.out.println("Bit operations........");
        System.out.println("");
        int number = 42;
        int possition = 3;
        String numInBinary = Integer.toBinaryString(number);
        System.out.println("Integer.toBinaryString(number) = " + numInBinary);
        System.out.printf("Is the %dth possition 1 in %s: %b %n", possition, numInBinary, getBit(number, possition));

        System.out.printf("Set bit at %d index in %s to 1. Binary result: %s and int result: %d%n", possition,
                numInBinary, Integer.toBinaryString(setBitToOne(number, possition)), setBitToOne(number, possition));

        System.out.printf("Set bit at %d index in %s to 0. Binary result: %s and int result: %d%n", possition,
                numInBinary, Integer.toBinaryString(setBitToZero(number, possition)), setBitToZero(number, possition));

        System.out.printf("Set all bits from MSB through %d index in %s to 0. Binary result: %s and int result: %d%n",
                possition, numInBinary, Integer.toBinaryString(clearBitsMSBthroughI(number, possition)),
                clearBitsMSBthroughI(number, possition));

        System.out.printf(
                "Set all bits from %d index through 0 index in %s to 0. Binary result: %s and int result: %d%n",
                possition, numInBinary, Integer.toBinaryString(clearBitsithrough0(number, possition)),
                clearBitsithrough0(number, possition));

        System.out.printf("Update bit at %d index in %s to 0. Binary result: %s and int result: %d%n", possition,
                numInBinary, Integer.toBinaryString(updateBit(number, possition, false)),
                updateBit(number, possition, false));


        System.out.println("Integer.toBinaryString(1) = " + Integer.toBinaryString(1));
    }


    private static int updateBit(int number, int possition, boolean bitIsOne) {
        int value = bitIsOne ? 1 : 0;
        int mask = ~(1 << possition);
        return (number & mask) | (value << possition);
    }

    private static int clearBitsithrough0(int number, int possition) {
        System.out.println("Integer.toBinaryString(-1) = " + Integer.toBinaryString(-1));
        int mask = -1 << possition + 1;
        System.out.println("mask = " + Integer.toBinaryString(mask));
        return number & mask;
    }

    private static int clearBitsMSBthroughI(int number, int possition) {
        int mask = (1 << possition) - 1;
        System.out.println("mask = " + Integer.toBinaryString(mask));
        return number & mask;
    }

    private static int setBitToZero(int number, int possition) {
        int mask = ~(1 << possition);
        return number & mask;
    }

    static int repeatedArithmeticShift(int x, int count) {
        for (int i = 0; i < count; i++) {
            x >>= 1; // arithmentic shift by 1
        }
        return x;
    }

    static int repeatedLogicalShift(int x, int count) {
        for (int i = 0; i < count; i++) {
            x >>>= 1; // Logical shift by 1
        }
        return x;
    }


    // checks if the index-th bit is 1 (index is 0 based)
    static boolean getBit(int num, int index) {
        return (num & (1 << index)) != 0;
    }

    // sets the bit at index to 1 (index is 0 based)
    static int setBitToOne(int num, int index) {
        return num | (1 << index);
    }
}
