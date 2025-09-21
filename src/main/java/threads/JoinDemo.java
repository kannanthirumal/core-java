package threads;

import java.util.Scanner;

public class JoinDemo extends Thread {
    static int n, sum = 0;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        System.out.println("sum of first 'N' numbers");
        System.out.println("Enter a value: ");

        Scanner sc = new Scanner(System.in);
        JoinDemo.n = sc.nextInt();

        JoinDemo jd = new JoinDemo();
        jd.start();

        try {
            jd.join(); //makes the thread in which this join() method is invoked to wait - here main method waits for the 'jd' thread to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sum of first 'N' numbers: " + JoinDemo.sum);

        long end = System.currentTimeMillis();
        /* div by 1000 coz "end - start" will be in milliseconds */
        System.out.println("Total execution time: " + (end - start) / 1000 + " seconds");
    }

    public void run() {
        for (int i = 1; i <= n; i++) {
            JoinDemo.sum += i;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
