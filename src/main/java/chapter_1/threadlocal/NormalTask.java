package chapter_1.threadlocal;

public class NormalTask implements Runnable{

    private ThreadLocal<StringBuilder> text = new ThreadLocal<StringBuilder>(){
        protected StringBuilder initialValue(){
            return new StringBuilder();
        }
    };

    public void run() {
        for (int i = 0; i < 5; i++) {
            text.get().append(i);
        }
        System.out.println("Normal: " + text.get().toString());
    }
}