package chapter_2.conditionallock;

public class Main {

    public static void main(String[] args) {

        FileMock fileMock = new FileMock(100);
        TwoLineBuffer buffer = new TwoLineBuffer(10);

        Thread producer1 = new Thread(new Producer(fileMock, buffer));
        Thread producer2 = new Thread(new Producer(fileMock, buffer));

        Thread consumer1 = new Thread(new Consumer(buffer));
        Thread consumer2 = new Thread(new Consumer(buffer));


        producer1.start();
        consumer1.start();
        producer2.start();
        consumer2.start();

    }

}
