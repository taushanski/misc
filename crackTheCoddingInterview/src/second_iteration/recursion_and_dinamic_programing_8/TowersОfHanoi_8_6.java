package second_iteration.recursion_and_dinamic_programing_8;

import java.util.Stack;

public class TowersОfHanoi_8_6 {

    public static void main(String[] args) {
        Tower[] towers = new Tower[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }

        int n = 10;
        for (int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }
        System.out.println("source = " + towers[0]);
        System.out.println("buffer = " + towers[2]);
        System.out.println("destination = " + towers[1]);
        towers[0].moveDiscs(n, towers[1], towers[2]);
        System.out.println("move finished!");

        System.out.println("source = " + towers[0]);
        System.out.println("buffer = " + towers[2]);
        System.out.println("destination = " + towers[1]);

    }

    public static class Tower {

        private Stack<Integer> discs;

        private int index;

        public Tower(int index) {
            this.index = index;
            discs = new Stack<>();

        }

        public void add(int ring) {
            if (!discs.isEmpty() && discs.peek() <= ring) {
                throw new IllegalArgumentException("Cannot put bigger disc on top of smaller one ");
            } else {
                discs.push(ring);
            }
        }


        public void moveDiscs(int n, Tower destination, Tower buffer) {
            if (n > 0) {
                moveDiscs(n - 1, buffer, destination);
                moveTopTo(destination);
                buffer.moveDiscs(n - 1, destination, this);
            }
        }

        private void moveTopTo(Tower destination) {
            destination.add(discs.pop());
        }

        @Override
        public String toString() {
            return "Tower{" +
                    " index=" + index +
                    ", discs=" + discs +
                    '}';
        }
    }

}
