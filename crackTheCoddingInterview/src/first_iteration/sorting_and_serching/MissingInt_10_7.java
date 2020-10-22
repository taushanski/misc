package first_iteration.sorting_and_serching;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MissingInt_10_7 {


    public static void main(String[] args) throws FileNotFoundException {

        /*We have 1 GB of memory, or 8 billion bits. Thus, with 8 billion bits, we can map all possible integers to a distinct bit with the available memory. The logic is as follows:
         * 1. Create a bit vector (BV) with 4 billion bits. Recall that a bit vector is an array that compactly stores
         * boolean values by using an array of ints (or another data type). Each int represents 32 boolean values.
         * 2. Initialize BV with all Os.
         * 3. Scan all numbers (num) from the file and call BV. set (num, 1) .
         * 4. Now scan again BV from the 0th index.
         * 5. Return the first index which has a valueof 0.*/


        String fileName = "/Users/i059884/Downloads/numbers";

        findOpenNumber(fileName);
    }

    private static void findOpenNumber(String fileName) throws FileNotFoundException {
        long numberOfNumbers = ((long) Integer.MAX_VALUE) + 1;
        byte[] bitVector = new byte[(int) (numberOfNumbers / 8)];

        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            while (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                /** Finds the corresponding number in the BV by using the OR operator to
                 * set the nth bit of a byte (e.g., 10 would correspond to the 2nd bit of
                 * index 2 in the byte array). */
                bitVector[n / 8] |= 1 << (n % 8);

            }
        }

        for (int i = 0; i < bitVector.length; i++) {
            byte nextByte = bitVector[i];
            for (int j = 0; j < 8; j++) {
                /* Retrieves the individual bits of each byte. When 0 bit is found, print
                 * the corresponding value. */
                if ((nextByte & (1 << j)) == 0) {
                    System.out.printf("The free int number is %d", (i * 8 + j));
                    return;
                }
            }
        }
    }
}
