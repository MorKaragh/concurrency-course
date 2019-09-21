package chapter_2.lock;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("*****NOT FAIR*****");
        PrintQueue printQueue = new PrintQueue(false);
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Job(printQueue));
            threads[i] = t;
            Thread.sleep(100);
            t.start();
        }

        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }

        System.out.println("*******FAIR*******");

        printQueue = new PrintQueue(true);

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Job(printQueue));
            threads[i] = t;
            Thread.sleep(100);
            t.start();
        }

        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }

    }

}
