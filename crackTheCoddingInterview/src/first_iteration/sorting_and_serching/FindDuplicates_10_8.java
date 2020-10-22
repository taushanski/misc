package first_iteration.sorting_and_serching;

public class FindDuplicates_10_8 {
    /*10.8 Find Duplicates: You have an array with all the numbers from 1 to N,
    where N is at most 32,000. The array may have duplicate entries and you do not
    know what N is. With only 4 kilobytes of memory available, how would you
    print all duplicate elements in the array?*/

    public static void main(String[] args) {
        int[] array = {1, 5, 66, 66, 66, 70, 71, 71, 65};
        checkDuplicates(array);

    }


    /* We have 4 kilobytes of memory which means we can address up to 8 * 4 * 2^10 bits. Note that 32 * 2^10
     * bits is greater than 32000. We can create a bit vector with 32000 bits, where each bit represents one integer.
     * Using this bit vector, we can then iterate through the array, flagging each element v by setting bit v to 1.
     * When we come across a duplicate element, we print it.*/
    static void checkDuplicates(int[] array) {

        BitSet bs = new BitSet(32000);
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int num0 = num - 1; // bitset starts at 0 numbers starts at 1
            if (bs.get(num0)) {
                System.out.println(num);
            } else {
                bs.set(num0);
            }
        }
    }

    public static class BitSet {
        int[] bitset;

        public BitSet(int size) {
            bitset = new int[(size >> 5) + 1]; // divide by 32
        }


        public boolean get(int pos) {
            int wordNumber = (pos >> 5); // divide by 32
            int bitNumber = (pos % 32); // mod 32
            return ((bitset[wordNumber]) & (1 << bitNumber)) != 0;
        }


        public void set(int pos) {
            int wordNumber = (pos >> 5); // divide by 32
            int bitNumber = (pos & 32); // mod 32
            bitset[wordNumber] |= 1 << bitNumber;
        }
    }

}
