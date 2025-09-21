package threads.thread_communication;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        t1.start();

        synchronized (myRunnable) {
            System.out.println("Main Thread is going to wait!");
            myRunnable.wait(); // main thread waits until notify() is called
            System.out.println("Main Thread is notified!");
        }

        System.out.println("Sum: " + myRunnable.total);
    }
}

/*
output
----------
Main Thread is going to wait!
Child thread is calculating the sum
Main Thread is notified!
Sum: 100
 */


/*
Case 1: Main thread gets lock first
    - Main thread enters synchronized(myRunnable).
    - Calls myRunnable.wait().
    - This releases the lock immediately.
    - Main thread goes into WAITING state.
    - Now child thread (t1) can enter synchronized(this) and do its work.
    - t1 calls notify(), which wakes the main thread.
    - Main thread continues after wait() and prints the result. ✅
    👉 This is the intended flow.

Case 2: Child thread gets lock first
    - Child thread enters synchronized(this) and calculates the sum.
    - Calls this.notify().
    - But at this time, the main thread has not yet called wait().
    - So the notification is lost. 🚨
    - Child thread exits, job done.
    - Main thread later enters synchronized(myRunnable) and calls wait().
    - But no one will ever notify it now.
    Main thread hangs forever. ❌

⚠️ That’s the Risk with wait() / notify()
    - This is why they are tricky and considered low-level.
    - If notify() happens before wait(), the waiting thread may never wake up.

✅ Safer Alternatives
    - join() → If you just want to wait for a thread to finish.

t1.start();
t1.join();  // main waits until t1 finishes
System.out.println("Sum: " + myRunnable.total);

 */

