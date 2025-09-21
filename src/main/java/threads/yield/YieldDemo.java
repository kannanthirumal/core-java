package threads.yield;
/*

 - The current thread moves from running to runnable state, allowing other threads of the same or higher priority to run.
 - If no other threads are ready to run, the yield has little or no effect; the current thread may resume immediately.
 - There is no defined or guaranteed waiting period when yield() is called.
 - The duration depends completely on the thread scheduler implementation by the OS or JVM and can vary between platforms.
 - It is possible the current thread can continue running immediately after yielding if no other threads take over.
*/

public class YieldDemo {
    public static void main(String[] args) {
        ChildClass childClass = new ChildClass();
        Thread t1 = new Thread(childClass);
        t1.start();

        for(int i=0;i<=100;i++){
            System.out.println("Main Thread");
        }
    }
}
