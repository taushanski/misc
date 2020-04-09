package threads.philosophers;

import java.util.Arrays;

public class Philosopher extends Thread {
    private final String name;
    private final int bites = 10;
    private final Chopstick left;
    private final Chopstick right;

    public Philosopher(String name, Chopstick left, Chopstick right) {
        this.left = left;
        this.right = right;
        this.name = name;
    }

    public void eat() {
        think();
        if (pickUp()) {
            chew();
            putDown();
        }
    }

    private void think() {
        try {
            Thread.sleep(100);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean pickUp() {
        /*try to pick up */
        if (!left.pickUp()) {
            System.out.printf("The Philosopher %s could not obtain the left chopstick%n", name);
            return false;
        }
        think();
        if (!right.pickUp()) {
            System.out.printf("The Philosopher %s could not obtain the right chopstick so putting down the left one%n",
                    name);
            left.putDown();
            return false;
        }
        return true;


    }

    private void chew() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Philosopher %s chewing...%n", name);
    }

    private void putDown() {
        right.putDown();
        left.putDown();
    }

    @Override
    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
        }
    }

    public static void main(String[] args) {
        int numberOfPhilosophers = 100;
        Chopstick[] chopsticks = new Chopstick[numberOfPhilosophers];
        Arrays.fill(chopsticks, new Chopstick());
        Philosopher[] philosophers = new Philosopher[numberOfPhilosophers];
        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i] = new Philosopher(Integer.toString(i), chopsticks[i],
                    chopsticks[(i + 1) % numberOfPhilosophers]);
        }
        System.out.println("Start all philosophers");
        // start the threads
        for (int i = 0; i < philosophers.length; i++) {
            philosophers[i].start();
        }
    }
}
