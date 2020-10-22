import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {10, 11, 12, 5},
                {9, 8, 7, 6}
        };
        System.out.println("spiralTraverse(matrix) = " + spiralTraverse(matrix));
    }

    /*Complexity: O(n*m) which is equal to O(N) total number of elements  | O(N)*/
    public static List<Integer> spiralTraverse(int[][] array) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();
        int startRow = 0;
        int endRow = array.length - 1;
        int startColumn = 0;
        int endColumn = array[0].length - 1;
        while (startRow <= endRow && startColumn <= endColumn) {
            // go through the start row
            for (int column = startColumn; column <= endColumn; column++) {
                result.add(array[startRow][column]);
            }

            // go down through the endcolumn
            for (int row = startRow + 1; row <= endRow; row++) {
                result.add(array[row][endColumn]);
            }
            // go left through the endRow
            for (int column = endColumn - 1; column >= startColumn; column--) {
                if (startRow == endRow) {
                    break;
                }
                result.add(array[endRow][column]);
            }
            // go up through the startColumn
            for (int row = endRow - 1; row > startRow; row--) {
                if (startColumn == endColumn) {
                    break;
                }
                result.add(array[row][startColumn]);
            }
            startRow++;
            endRow--;
            startColumn++;
            endColumn--;
        }
        return result;
    }

}
