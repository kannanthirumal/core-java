package threads.deadlocks;

public class SecondResource {
    public synchronized void method1(FirstResource fr) {
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Inside SecondResource: Invoking the method2 of FirstResource");
        fr.method2();
    }

    public synchronized void method2() {
        System.out.println("Inside method2 of SecondResource");
    }
}
