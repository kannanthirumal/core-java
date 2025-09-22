package threads.deadlocks;

public class DeadLockDemo implements Runnable {
    FirstResource fr;
    SecondResource sr;

    public DeadLockDemo() {
        fr = new FirstResource();
        sr = new SecondResource();

        /* we are in main thread and spinning a new thread */
        new Thread(this).start();

        /* started a new thread above and rn we are in main thread */
        sr.method1(fr);
    }

    public static void main(String[] args) {
        new DeadLockDemo();
    }

    @Override
    public void run() {
        fr.method1(sr);
    }
}

/*
    new thread acquires lock on First Resource //coz it's within the run method
    Main thread acquires lock on Second Resource

    When both try to invoke each others method2 - they will end up in a deadlock
 */