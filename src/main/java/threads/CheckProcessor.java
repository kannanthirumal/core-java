package threads;

public class CheckProcessor implements Runnable {
    @Override
    public void run() {
        System.out.println("Processed the checks");
    }

    public static void main(String[] args) {
        CheckProcessor cp = new CheckProcessor();
        Thread t1 = new Thread(cp); //thread takes the runnable
        t1.start();
    }
}
