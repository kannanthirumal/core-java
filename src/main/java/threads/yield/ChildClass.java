package threads.yield;

public class ChildClass implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            System.out.println("Child Thread");
            Thread.yield();
        }
    }
}
