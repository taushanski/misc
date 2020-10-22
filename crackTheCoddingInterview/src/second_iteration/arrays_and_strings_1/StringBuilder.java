package second_iteration.arrays_and_strings_1;

import java.util.Arrays;

import static java.util.Objects.requireNonNull;

public class StringBuilder {

    private static final int DEFAULT_BUFFER_SIZE = 16;

    private static final int BUFFER_MULTIPLIER = 2;

    private char[] data;

    private int bufferSize;

    // Number of characters in the string so far
    private int charCount;

    public StringBuilder() {
        this.bufferSize = DEFAULT_BUFFER_SIZE;
        this.data = new char[DEFAULT_BUFFER_SIZE];
    }

    /**
     * @param size The initial size of the underlying character array.
     */
    public StringBuilder(int size) {

    }

    /**
     * @param str a character array
     */
    public StringBuilder(char[] str) {
        this(-1, str);
    }

    /**
     * @param str A string containing the intitial value of character buffer;
     */
    public StringBuilder(String str) {
        this(-1, str.toCharArray());
    }

    public StringBuilder(int size, char[] str) {
        requireNonNull(str);
        this.bufferSize = Integer.max(Integer.max(size, str.length), DEFAULT_BUFFER_SIZE);
        this.data = Arrays.copyOf(str, this.bufferSize);
        this.charCount = str.length;
    }

    /**
     * @param str The string to append to the string builder
     * @return <code>this</code>. In other words, the<code>StringBuilder</code> so that we can chain methods
     */
    public StringBuilder append(String str) {
        while (resizeRequired(str)) {
            resizeBuffer(str);
        }
        addString(str);
        updateCharCount(str.length());
        return this;
    }

    /**
     * @param newInput The new string appended by the consumer
     * @return <code>true</code> if underlying char array needs to be resized
     * */
    private boolean resizeRequired(String newInput) {
        return this.charCount + newInput.length() > this.bufferSize;
    }

    /**
     * Resize the underlying character array if the existing char
     * array is about to overflow.
     * @param newInput The new string appended by the consumer
     * */
    private void resizeBuffer(String newInput) {
        int oldSize = this.bufferSize;
        this.bufferSize *= BUFFER_MULTIPLIER; // Update buffer size
        char[] newStr = new char[this.bufferSize];
        System.out.printf("Resizing array: Increasing size from %d to %d\n", oldSize, this.bufferSize);
        // Copy to new array
        System.arraycopy(this.data, 0, newStr, 0, oldSize);
        // Set new array
        this.data = newStr;
    }

    private void addString(String str) {
        // Copy elements from string to append into the underlying char array.
        System.arraycopy(str.toCharArray(), 0,
                         this.data,  this.charCount , str.length());
    }

    private void updateCharCount(int charCount) {
        this.charCount += charCount;
    }

}
