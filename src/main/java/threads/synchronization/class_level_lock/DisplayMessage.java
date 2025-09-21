package threads.synchronization.class_level_lock;

public class DisplayMessage {
    public synchronized static void sayHello(String name) {
        try {
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(1000);
                System.out.println("Hello, How are you " + name);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
