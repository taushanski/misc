import java.util.Arrays;
import java.util.List;

public class ValidateSubsequence {


    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 1, 6, 1);
        List<Integer> sequence = Arrays.asList(1, 1, 1, 6);
        long startTime = System.currentTimeMillis();
        boolean isValidSequenceResult = isValidSubsequence(array, sequence);
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println(
                "isValidSubsequence(array, sequence) = " + isValidSequenceResult + " : took " + endTime + " " +
                        "ms.");
        startTime = System.currentTimeMillis();
        boolean isValidSubsequenceOptimized = isValidSubsequenceOptimized(array, sequence);
        endTime = System.currentTimeMillis() - startTime;
        System.out.println(
                "isValidSubsequenceOptimized(array, sequence) = " + isValidSubsequenceOptimized + " : took " + endTime + " " +
                        "ms.");
    }

    // let array.size() = n, sequence.size() = m -> time O(m*n)
    private static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int nextSequenceElementStartIndex = 0;
        for (int i = 0; i < sequence.size(); i++) {
            int nextSequenceElement = sequence.get(i);
            nextSequenceElementStartIndex = getElementIndex(array, nextSequenceElement, nextSequenceElementStartIndex);
            if (nextSequenceElementStartIndex < 0) {
                return false;
            }
        }
        return true;
    }

    private static int getElementIndex(List<Integer> array, int elementToCheck, int startIndex) {
        for (int i = startIndex; i < array.size(); i++) {
            if (elementToCheck == array.get(i)) {
                return i;
            }
        }
        return -1;
    }

    // let array.size() = n, sequence.size() = m -> time O(m*n)
    private static boolean isValidSubsequenceOptimized(List<Integer> array, List<Integer> sequence) {
        if (sequence == null || array == null || sequence.size() > array.size()) {
            return false;
        }
        int mainArrayIndex = 0;
        int sequenceIndex = 0;
        while (mainArrayIndex < array.size() && sequenceIndex < sequence.size()) {
            int nextSequenceElement = sequence.get(sequenceIndex);
            boolean nextSequenceElementContained = false;
            for (; mainArrayIndex < array.size(); mainArrayIndex++) {
                int nextArrayElement = array.get(mainArrayIndex);
                if (nextArrayElement == nextSequenceElement) {
                    mainArrayIndex++;
                    nextSequenceElementContained = true;
                    break;
                }
            }
            if (!nextSequenceElementContained) {
                return false;
            }
            sequenceIndex++;
        }
        if (mainArrayIndex == array.size() && sequenceIndex < sequence.size()) {
            return false;
        }
        return true;
    }
}
