package threads.synchronization.synchronized_method;

public class DisplayMessage {
    public synchronized void sayHello(String name) {
        try {
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(2000);
                System.out.println("Hello, How are you " + name);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
