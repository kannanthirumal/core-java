package threads.thread_communication;

public class MyRunnable implements Runnable {
    public int total = 0;

    @Override
    public void run() {
        System.out.println("Child thread is calculating the sum");

        synchronized (this) {
            for (int i = 1; i <= 100; i++) {
                total += 1;
            }
            this.notify(); // wake up the waiting main thread
        }
    }
}

