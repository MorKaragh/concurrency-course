package chapter_1.threadlocal;

public class Main {

    public static void main(String[] args) {
        Runnable crazy = new CrazyTask();
        Runnable normal = new NormalTask();

        Thread t1 = new Thread(crazy);
        Thread t2 = new Thread(crazy);

        t1.start();
        t2.start();

        t1 = new Thread(normal);
        t2 = new Thread(normal);

        t1.start();
        t2.start();
    }

}
