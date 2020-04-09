package dynamic_programing_and_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EightQueens {

    static final int GRID_SIZE = 8;

    public static void main(String[] args) {
        ArrayList<Integer[]> results = new ArrayList<>();
        placeQueens(0, new Integer[GRID_SIZE], results);
        System.out.println("results.size() = " + results.size());
        System.out.println("results = " + results.stream().map(Arrays::toString).collect(Collectors.toList()));
    }

    private static void placeQueens(int row, Integer[] columns, List<Integer[]> results) {
        if (row == GRID_SIZE) { // found solution
            results.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (checkValid(columns, row, col)) {
                    columns[row] = col; // valid position at [row][column]
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }

    /* Check if (rowl, column!) is a valid spot for a queen by checking if there is a
     * queen in the same column or diagonal. We don't have to check it for queens in the same row1 as the calling method placeQueens
     * only attempts to place one queen at time. We know that this row1 is empty*/
    private static boolean checkValid(Integer[] columns, int row1, int column1) {
        for (int row2 = 0; row2 < row1; row2++) {
            int column2 = columns[row2];
            /*
            Check if (row2, column2) invalidates (row1, column1)
             */
            // check if rows have queens in the same column
            if (column1 == column2) {
                return false;
            }

            /*Check diagonals: if the distance between the columns equals the distance
             * between the rows, then they're in the same diagonal. */
            int columnDistance = Math.abs(column1 - column2);

            // row1 > row2 so no need for abs
            int rowDistance = row1 - row2;
            if (columnDistance == rowDistance) {
                return false;
            }

        }

        return true;
    }
}
