package first_iteration.dynamic_programing_and_recursion;

import java.util.Stack;

public class TowersOfHanoi {

    public static void main(String[] args) {
        int n = 30;
        // initialize the towers
        Tower[] towers = new Tower[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }

        // add elements to source tower
        for (int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }

        System.out.println("source tower before move = " + towers[0]);

        towers[0].moveDisks(n, towers[2], towers[1]);

        System.out.println("source tower after move = " + towers[0]);
        System.out.println("destination tower after move = " + towers[2]);
    }

    private static class Tower {
        private final int index;
        private Stack<Integer> disks;

        public Tower(int index) {
            this.disks = new Stack<>();
            this.index = index;

        }

        public void add(int disk) {
            if (!disks.isEmpty() && disks.peek() <= disk) {
                System.err.println("Error placing disk" + disk);
            } else {
                disks.push(disk);
            }
        }


        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Tower{");
            sb.append("index=").append(index);
            sb.append(", disks=").append(disks);
            sb.append('}');
            return sb.toString();
        }

        public void moveDisks(int n, Tower destination, Tower buffer) {
            if (n > 0) {// base case
                moveDisks(n - 1, buffer, destination);
                moveTopTo(destination);
                buffer.moveDisks(n - 1, destination, this);
            }
        }

        private void moveTopTo(Tower destination) {
            int disk = disks.pop();
            destination.add(disk);
        }
    }


}
