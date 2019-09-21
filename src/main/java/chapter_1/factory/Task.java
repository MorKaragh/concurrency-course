package chapter_1.factory;

import java.math.BigInteger;

public class Task implements Runnable {
    public void run() {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i = 0; i < Integer.MAX_VALUE; i ++) {
            bigInteger = bigInteger.add(BigInteger.valueOf(i));
        }
        System.out.println(bigInteger.toString());
    }
}
