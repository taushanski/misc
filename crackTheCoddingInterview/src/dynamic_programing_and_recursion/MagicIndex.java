package dynamic_programing_and_recursion;

public class MagicIndex {

    public static void main(String[] args) {
        int[] numbers = {-11, -3, -2, -3, 3, 5};
        System.out.println("findMagicIndex(numbers) = " + findMagicIndex(numbers));
        System.out.println("findMagicIndex(numbers) = " + findMagicIndex2(numbers));

    }

    // O(N)
    private static int findMagicIndex(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == i) {
                return i;
            }
        }
        return -1;
    }

    // O(logN)
    private static int findMagicIndex2(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        return findMagicIndex2(numbers, 0, numbers.length - 1);
    }

    private static int findMagicIndex2(int[] numbers, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return -1;
        }
        int middleIndex = (endIndex + startIndex) / 2;
        if (numbers[middleIndex] == middleIndex) {
            return middleIndex;
        } else if (numbers[middleIndex] > middleIndex) {
            return findMagicIndex2(numbers, startIndex, middleIndex - 1);
        } else {
            return findMagicIndex2(numbers, middleIndex + 1, endIndex);
        }
    }

    private static int findMagicIndexWithDuplicates(int[] numbers) {
        return findMagicIndexWithDuplicates(numbers, 0, numbers.length - 1);
    }

    private static int findMagicIndexWithDuplicates(int[] numbers, int startIndex, int endIndex) {
        if (endIndex < startIndex) {
            return -1;
        }

        int middleIndex = (startIndex + endIndex) / 2;
        int middleValue = numbers[middleIndex];
        if (middleValue == middleIndex) {
            return middleIndex;
        }

        // search left side
        int leftEndIndex = Math.min(middleIndex - 1, middleValue);
        int leftIndex = findMagicIndexWithDuplicates(numbers, startIndex, leftEndIndex);
        if (leftIndex > 0) {
            return leftIndex;
        }

        // search right side
        int rigthBeginIndex = Math.max(middleIndex + 1, middleValue);
        int rightIndex = findMagicIndexWithDuplicates(numbers, rigthBeginIndex, endIndex);
        if (rightIndex > 0) {
            return rightIndex;
        }
        return -1;
    }


}
