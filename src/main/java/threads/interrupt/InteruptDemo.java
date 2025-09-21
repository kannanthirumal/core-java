package threads.interrupt;

public class InteruptDemo {
    public static void main(String[] args) {
        ChildClass c = new ChildClass();
        Thread t = new Thread(c);
        t.start();
        t.interrupt();

        /*
            - we can interrupt a thread only when it is in sleep mode
            - if I comment out the "Thread.sleep", I'm unable to interrupt it
            - and it keeps on printing like this
            End of the main method
            ---------------------------
            Hey, I'm the child thread
            Hey, I'm the child thread
            Hey, I'm the child thread
            .
            .
            .
        */

        System.out.println("End of the main method");
    }
}

/*
Output
----------

End of the main method
Hey, I'm the child thread
Child Thread Interrupted

 */