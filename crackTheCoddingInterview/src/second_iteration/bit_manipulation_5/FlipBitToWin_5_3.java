package second_iteration.bit_manipulation_5;

public class FlipBitToWin_5_3 {

    public static final int INT_TYPE_BITS = 32;

    public static void main(String[] args) {
        int input = Integer.MAX_VALUE;
        System.out.println("Integer.toBinaryString(input) = " + Integer.toBinaryString(input));
        System.out.println("findLongestSequence(input) = " + findLongestSequenceOf1s(input));
    }

    private static int findLongestSequenceOf1s(int input) {
        int longestSequence = 0;
        boolean bitFlipped = false;
        int currentSequence = 0;
        int indexOfLastFlippedBit = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            boolean isNextBitOne = getBit(input, i);
            if (isNextBitOne) {
                currentSequence++;
            } else if (!bitFlipped) {
                currentSequence++;
                bitFlipped = true;
                indexOfLastFlippedBit = i;
            } else {
                if (longestSequence < currentSequence) {
                    longestSequence = currentSequence;
                    i = indexOfLastFlippedBit;
                    bitFlipped = false;
                }
                currentSequence = 0;
            }
        }
        if (longestSequence < currentSequence) {
            longestSequence = currentSequence;
        }


        return longestSequence;
    }

    private static boolean getBit(int input, int i) {
        return (input & (1 << i)) != 0;
    }

}
