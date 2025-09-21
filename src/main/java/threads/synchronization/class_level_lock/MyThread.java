package threads.synchronization.class_level_lock;

public class MyThread implements Runnable {
    String name;
    public MyThread(String name) {

        this.name = name;
    }

    @Override
    public void run() {
        DisplayMessage.sayHello(name);
    }
}
