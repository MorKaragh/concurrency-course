package chapter_1.group;

public class Group extends ThreadGroup {

    public Group(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Exception " + e.getMessage() + " in thread " + t.getName());
        System.out.println("Interrupting other threads...");
        interrupt();
    }
}
