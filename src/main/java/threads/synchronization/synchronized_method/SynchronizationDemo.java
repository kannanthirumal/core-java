package threads.synchronization.synchronized_method;

public class SynchronizationDemo {
    public static void main(String[] args) {
        DisplayMessage dm = new DisplayMessage();

        MyThread runnable1 = new MyThread(dm, "spider-man");
        MyThread runnable2 = new MyThread(dm, "hulk");

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);

        t1.start();
        t2.start();
    }
}

/*
    Output behavior
    --------------------------------------------
    1. No mix up between the print statements of different threads.
    2. Whichever thread accesses sayHello() first will complete it entirely
       before the other thread takes over.
    3. Other threads wanting to access the method must wait.
    4. This happens because a thread takes the "intrinsic lock"
       of the object when entering a synchronized method.
 */
