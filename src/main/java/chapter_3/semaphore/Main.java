package chapter_3.semaphore;

public class Main {

    public static void main(String[] args) {

        PrintQueue queue = new PrintQueue();

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Job(queue));
            t.start();
        }
    }

}
