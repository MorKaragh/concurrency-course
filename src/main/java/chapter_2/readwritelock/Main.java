package chapter_2.readwritelock;

public class Main {

    public static void main(String[] args) {


        PriceInfo priceInfo = new PriceInfo();
        Thread[] readers = new Thread[5];

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new Reader(priceInfo));
            readers[i] = t;
        }

        Writer writer = new Writer(priceInfo);
        Thread writeThread = new Thread(writer);

        for (Thread t : readers) {
            t.start();
        }

        writeThread.start();

    }

}
