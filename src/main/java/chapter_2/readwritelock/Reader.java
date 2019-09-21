package chapter_2.readwritelock;

public class Reader implements Runnable {

    private PriceInfo priceInfo;

    public Reader(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("price1 = " + priceInfo.getPrice1());
            System.out.println("price2 = " + priceInfo.getPrice2());
        }
    }
}
