package chapter_1.group;

public class Main {

    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();

        Group group = new Group("Group of stupid threads");
        Task task = new Task();

        for (int i = 0; i < cores; i++) {
            Thread t = new Thread(group, task);
            t.start();
        }

        System.out.println("active threads: " + group.activeCount());
        group.list();

    }

}
