package sorting_and_serching;

public class SortedMatrixSearch_10_9 {
    public static void main(String[] args) {
        int[][] matrix = {{15, 20, 70, 85}, {25, 35, 80, 95}, {30, 55, 95, 105}, {40, 80, 100, 120}};

        System.out.println("findElement(matrix, 7) = " + findElement(matrix, 55));
        System.out.println("findElementBinarySearch(matrix, 55) = " + findElementBinarySearch(matrix, 55));

    }

    // O(M+N)
    private static boolean findElement(int[][] matrix, int element) {
        int row = 0;
        int col = matrix[0].length - 1;
        int iteration = 0;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == element) {
                System.out.println("iteration = " + iteration);
                return true;
            } else if (matrix[row][col] > element) {
                col--;
            } else {
                row++;
            }
            iteration++;
        }
        System.out.println("iteration = " + iteration);
        return false;
    }

    // binary search O(log n)
    private static Coordinate findElementBinarySearch(int[][] matrix, int element) {
        Coordinate origin = new Coordinate(0, 0);
        Coordinate destination = new Coordinate(matrix.length - 1, matrix[0].length);
        return findElementBinarySearch(matrix, element, origin, destination);
    }

    private static Coordinate findElementBinarySearch(int[][] matrix, int x, Coordinate origin,
            Coordinate destination) {
        if (!origin.inbounds(matrix) || !destination.inbounds(matrix) || !origin.isBefore(destination)) {
            return null;
        }

        if (matrix[origin.row][origin.column] == x) {
            return origin;
        }

        /*Set start to start of diagonal and end to the end of the diagonal. Since the
         * grid may not be square, the end of the diagonal may not equal dest.*/
        Coordinate start = origin.clone();
        int diagDist = Math.min(destination.row - origin.row, destination.column - origin.column);
        Coordinate end = new Coordinate(start.row + diagDist, start.column + diagDist);
        Coordinate p = new Coordinate(0, 0);

        /* Do binary search on the diagonal, looking for the first element> x*/
        while (start.isBefore(end)) {
            p.setToAverage(start, end);
            if (x > matrix[p.row][p.column]) { // move start in the right part of the diagonal
                start.row = p.row + 1;
                start.column = p.column + 1;
            } else { // move end to the left part of the diagonal
                end.row = p.row - 1;
                end.column = p.column - 1;
            }
        }

        /* Split the grid into quadrants. Search the bottom left and the top right. */
        return partitionAndSearch(matrix, x, origin, destination, start);


    }

    private static Coordinate partitionAndSearch(int[][] matrix, int x, Coordinate origin, Coordinate destination,
            Coordinate pivot) {
        Coordinate lowerLeftOrigin = new Coordinate(pivot.row, origin.column);
        Coordinate lowerLeftDest = new Coordinate(destination.row, pivot.column - 1);
        Coordinate upperRightOrigin = new Coordinate(origin.row, pivot.column);
        Coordinate upperRightDest = new Coordinate(pivot.row - 1, destination.column);

        Coordinate lowerLeft = findElementBinarySearch(matrix, x, lowerLeftOrigin, lowerLeftDest);
        if (lowerLeft == null) {
            return findElementBinarySearch(matrix, x, upperRightOrigin, upperRightDest);
        }
        return lowerLeft;
    }

    private static class Coordinate implements Cloneable {

        private int row;
        private int column;

        public Coordinate(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        protected Coordinate clone() {
            return new Coordinate(row, column);
        }

        public boolean inbounds(int[][] matrix) {
            return row >= 0 && row <= matrix.length && column >= 0 && column <= matrix[0].length;
        }

        public boolean isBefore(Coordinate destination) {
            return row <= destination.row && column <= destination.column;
        }

        public void setToAverage(Coordinate min, Coordinate max) {
            row = (min.row + max.row) / 2;
            column = (min.column + max.column) / 2;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Coordinate{");
            sb.append("row=").append(row);
            sb.append(", column=").append(column);
            sb.append('}');
            return sb.toString();
        }
    }
}
