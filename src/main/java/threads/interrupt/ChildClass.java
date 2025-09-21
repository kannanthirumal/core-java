package threads.interrupt;

public class ChildClass implements Runnable {
    public void run() {
//        try {
            for(int i=0;i<=100;i++){
                System.out.println("Hey, I'm the child thread");
//                Thread.sleep(2000);
            }
//        } catch (InterruptedException e) {
//           System.out.println("Child Thread Interrupted");
//        }
    }
}
