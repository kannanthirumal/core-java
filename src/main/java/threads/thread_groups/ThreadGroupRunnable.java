package threads.thread_groups;

public class ThreadGroupRunnable {
    public static void main(String[] args) {
        //ThreadGroup and creating / adding threads to the group using runnable

        ThreadGroup parent = new ThreadGroup("milky-way");

        //create runnable task
        Runnable r1 = new MyTask();

        //create threads inside the group
        Thread t1 = new Thread(parent, r1);
        Thread t2 = new Thread(parent, r1);
        Thread t3 = new Thread(parent, r1);

        t1.start();
        t2.start();
        t3.start();

        //group level info
        System.out.println("Active threads in group: " + parent.activeCount());
        //prints details of group and threads
        parent.list();

    }
}

class MyTask implements Runnable {
    @Override
    public void run() {
        for(int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " performing step -> " + i);
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted");
            }
        }
    }
}
