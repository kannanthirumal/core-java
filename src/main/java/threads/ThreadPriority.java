package threads;

public class ThreadPriority extends Thread {
    public static void main(String[] args) {
        ThreadPriority t1 = new ThreadPriority();
        t1.setPriority(Thread.MIN_PRIORITY);
        t1.setName("t1");
        /*
            MIN_PRIORITY => 1
            MAX_PRIORITY => 10
            NORM_PRIORITY => 5
         */

        ThreadPriority t2 = new ThreadPriority();
        t2.setPriority(Thread.MAX_PRIORITY);
        t2.setName("t2");

        t1.start();
        t2.start();




    }

    public void run() {
        System.out.println("Current thread name is: " + Thread.currentThread().getName());
    }
}

/*
output (most cases it works but still we can't guarantee the order)
----------
Current thread name is: t2
Current thread name is: t1


 */
