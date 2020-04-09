package dynamic_programing_and_recursion;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class RobotInAGrid {

    public static void main(String[] args) {
        {
            // solution 1
            int[][] maze = {{0, 1, 0}, {0, 0, 1}, {1, 0, 0}};
            Stack<String> path = new Stack<>();
            System.out.println("findPath(maze) = " + findPath(maze, path));
            printPath(path);
        }
        System.out.println();
        {
            // solution 2
            boolean[][] maze = {{true, false, true}, {true, true, false}, {false, true, true}};
            System.out.println("getPath(maze) = " + getPath(maze));
        }
    }

    private static boolean findPath(int[][] maze, Stack<String> path) {
        return findPath(maze, 0, 0, path);
    }

    private static boolean findPath(int[][] maze, int row, int column, Stack<String> path) {
        if (row >= maze.length || column >= maze[0].length || maze[row][column] == 1) {
            return false;
        } else if (row == maze.length - 1 && column == maze[0].length - 1) {
            path.push(String.format("(%d,%d)", row, column));
            return true;
        } else { // try the right path and then the down path
            boolean pathExists = findPath(maze, row, column + 1, path) || findPath(maze, row + 1, column, path);
            if (pathExists) {
                path.push(String.format("(%d,%d)", row, column));
            }
            return pathExists;
        }
    }

    private static void printPath(Stack<String> path) {
        while (!path.isEmpty()) {
            System.out.printf("%s, ", path.pop());
        }
    }

    private static List<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) {
            return null;
        }
        List<Point> path = new ArrayList<>();
        Set<Point> failedPoints = new HashSet<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    // the complexity without the failedPoints is O(2^r+c) with it it takes O(r*c)
    private static boolean getPath(boolean[][] maze, int row, int column, List<Point> path, Set<Point> failedPoints) {
        if (row < 0 || column < 0 || !maze[row][column]) {
            return false;
        }

        /* If we've already visited this cell, return. */
        Point p = new Point(row, column);
        if (failedPoints.contains(p)) {
            return false;
        }

        boolean isAtOrigin = (row == 0) && (column == 0);
        /*If there's a path from the start to here, add my location.*/
        if (isAtOrigin || getPath(maze, row, column - 1, path, failedPoints) || getPath(maze, row - 1, column, path,
                failedPoints)) {
            path.add(p);
            return true;
        }
        failedPoints.add(p);// Cache result
        return false;
    }


    private static class Point {
        private int row;
        private int column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Point{");
            sb.append("row=").append(row);
            sb.append(", column=").append(column);
            sb.append('}');
            return sb.toString();
        }
    }
}
