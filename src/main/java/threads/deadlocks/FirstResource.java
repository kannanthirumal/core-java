package threads.deadlocks;

public class FirstResource {
    public synchronized void method1(SecondResource sr) {
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Inside FirstResource: Invoking the method2 of SecondResource");
        sr.method2();
    }

    public synchronized void method2() {
        System.out.println("Inside method2 of FirstResource");
    }
}
