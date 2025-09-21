package threads;

public class NamingThreads extends Thread {
    public static void main(String[] args) {

        NamingThreads t1 = new NamingThreads();
        t1.start();

        Thread curThread = Thread.currentThread();
        System.out.println("Current thread name is: " + curThread.getName());

    }

    public void run() {
        Thread curThread = Thread.currentThread();
        System.out.println("Current thread name is: " + curThread.getName());

        //giving this thread a new name
        curThread.setName("Kannan's thread");
        System.out.println("Current thread name is: " + curThread.getName());
    }
}

/* (the print statement order can be different)

Current thread name is: main
Current thread name is: Thread-0
Current thread name is: Kannan's thread
 */