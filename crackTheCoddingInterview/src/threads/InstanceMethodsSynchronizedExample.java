package threads;

public class InstanceMethodsSynchronizedExample {


    private static class MyClass extends Thread {
        private String name;
        private MyObject myObj;

        public MyClass(String name, MyObject myObj) {
            this.name = name;
            this.myObj = myObj;
        }

        @Override
        public void run() {
            myObj.foo(name);
        }
    }

    private static class MyObject {
        public synchronized void foo(String name) {
            try {
                System.out.printf("Thread %s.foo starting...%n", name);
                Thread.sleep(3000);
                System.out.printf("Thread %s.foo ending...%n", name);
            } catch (InterruptedException e) {
                System.out.printf("Thread %s interrupted%n", name);
            }
        }
    }

    public static void main(String[] args) {
        MyObject obj1 = new MyObject();
        MyObject obj2 = new MyObject();

        MyClass thread1 = new MyClass("1", obj1);
        MyClass thread2 = new MyClass("2", obj1);
        thread1.start();
        thread2.start();
    }
}
