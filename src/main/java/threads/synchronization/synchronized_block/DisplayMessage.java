package threads.synchronization.synchronized_block;

public class DisplayMessage {
    public void sayHello(String name) {
        try {
            synchronized (this) {
                for (int i = 1; i <= 10; i++) {
                    Thread.sleep(2000);
                    System.out.println("Hello, How are you " + name);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
