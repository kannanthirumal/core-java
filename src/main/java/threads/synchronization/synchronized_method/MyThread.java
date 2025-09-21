package threads.synchronization.synchronized_method;

public class MyThread implements Runnable {
    DisplayMessage dm;
    String name;
    public MyThread(DisplayMessage dm, String name) {
        this.dm = dm;
        this.name = name;
    }

    @Override
    public void run() {
        dm.sayHello(name);
    }
}
