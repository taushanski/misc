package threads;

public class RunnableThreadExample implements Runnable {
    int count = 0;

    @Override
    public void run() {
        System.out.println("RunnableThread starting...");


        try {
            while (count < 5) {
                Thread.sleep(500);
                count++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("RunnableThread terminating");
    }

    public static void main(String[] args) {
        RunnableThreadExample instance = new RunnableThreadExample();
        Thread thread = new Thread(instance);
        thread.start();

        /*waits until above thread counts to 5 (slowly)*/
        while (instance.count != 5) {
            try {
                System.out.println("Still waiting count =" + instance.count);
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
