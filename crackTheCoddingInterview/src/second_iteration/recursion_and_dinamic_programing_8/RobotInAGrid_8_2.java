package second_iteration.recursion_and_dinamic_programing_8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RobotInAGrid_8_2 {

    public static void main(String[] args) {
        boolean[][] maze = {
                {true, false, false, false},
                {true, true, false, false},
                {false, true, false, false},
                {false, true, true, true}
        };

        System.out.println(" = " + findPath(maze));
        System.out.println(" = " + findPathMemoization(maze));


    }

    /*O(2^(r+c))*/
    private static List<Point> findPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) {
            return null;
        }
        List<Point> path = new ArrayList<>();
        if (findPath(maze, maze.length - 1, maze[0].length - 1, path)) {
            return path;
        }
        return null;
    }

    private static boolean findPath(boolean[][] maze, int row, int column, List<Point> path) {
        if (row < 0 || column < 0 || !maze[row][column]) {
            return false;
        }
        boolean isAtStart = row == 0 && column == 0;
        if (isAtStart || findPath(maze, row - 1, column, path) || findPath(maze, row, column - 1, path)) {
            // add current location
            path.add(new Point(row, column));
            return true;
        }

        return false;

    }

    /* O(r*c)*/
    private static List<Point> findPathMemoization(boolean[][] maze) {
        if (maze == null || maze.length == 0) {
            return null;
        }
        List<Point> path = new ArrayList<>();
        Set<Point> failedPoints = new HashSet<>();
        if (findPathMemoization(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    private static boolean findPathMemoization(boolean[][] maze, int row, int column, List<Point> path,
                                               Set<Point> failedPoints) {
        if (row < 0 || column < 0 || !maze[row][column]) {
            return false;
        }
        Point p = new Point(row, column);
        if (failedPoints.contains(p)) {
            return false;
        }
        boolean isAtStart = row == 0 && column == 0;
        if (isAtStart || findPath(maze, row - 1, column, path) || findPath(maze, row, column - 1, path)) {
            // add current location
            path.add(p);
            return true;
        }

        failedPoints.add(p);// cache result
        return false;
    }


    static class Point {

        final int row;

        final int column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "row=" + row +
                    ", column=" + column +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (row != point.row) return false;
            return column == point.column;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + column;
            return result;
        }
    }


}
