package second_iteration.bit_manipulation_5;

public class BitTasks {

    public static void main(String[] args) {
        int number = 15;
        System.out.println("getBit(number, 2) = " + getBit(number, 3));
//        System.out.println(1<<2);
        System.out.println("setBit(number, 3) = " + setBit(number, 3));
        System.out.println("clearBit(number, 3) = " + clearBit(number, 2));
        System.out.println("clearBit(number, 3) = " + clearBitsMSBthroughI(number, 2));
        System.out.println("clearBit(number, 3) = " + clearBitsIthrough0(number, 2));
        System.out.println("updateBit(number, 0, false) = " + updateBit(number, 0, false));
        System.out.println("updateBit(number, 0, false) = " + updateBit(number, 1, false));
    }

    private static boolean getBit(int number, int bitNumber) {
        return ((number & (1 << bitNumber)) != 0);
    }

    private static int setBit(int number, int bitNumber) {
        return number | (1 << bitNumber);
    }

    public static int clearBit(int number, int bitNumber) {
        int mask = ~(1 << bitNumber); // git a number of the pattern 111101111
        return number & mask; // this should clear only the respective bit at position bitnumber
    }

    public static int clearBitsMSBthroughI(int number, int bitNumber) {
        int mask = (1 << bitNumber) - 1;
        return number & mask;
    }

    public static int clearBitsIthrough0(int number, int bitNumber) {
        int mask = (-1 << (bitNumber + 1)); // -1 = 1111111 left shift it with bitNumber +1 => 1s in the MSB followed
        // by bitNumber 0s
        return number & mask;
    }

    public static int updateBit(int num, int bitNumber, boolean bitisl) {
        int value = bitisl ? 1 : 0;
        int mask = ~(1 << bitNumber);
        return (num & mask) | (value << bitNumber);
    }

}
