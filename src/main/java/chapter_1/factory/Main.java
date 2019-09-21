package chapter_1.factory;

public class Main {

    public static void main(String[] args) {
        Factory factory = new Factory();

        for (int i = 0; i < 10; i++) {
            factory.newThread(new Task()).start();
        }

        System.out.println("chapter_1.factory created " + factory.getCounter() + " threads");

    }

}
