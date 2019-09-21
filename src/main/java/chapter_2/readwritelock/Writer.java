package chapter_2.readwritelock;

public class Writer implements Runnable {

    private PriceInfo priceInfo;

    public Writer(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {
        System.out.println("пробуем установить значения");
        priceInfo.setPrices(Math.random()*8, Math.random()*10);
        System.out.println("установили значения");
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
