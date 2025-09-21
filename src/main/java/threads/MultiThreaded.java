package threads;

public class MultiThreaded extends Thread {
    public static void main(String[] args) {

        MultiThreaded mt = new MultiThreaded();
        mt.start();


        for (int j = 1; j <= 200; j++) {
            System.out.println("j: " + j);
        }
    }

    public void run () {
        for (int i = 1; i <= 200; i++) {
            System.out.println("i: " + i);

            try {
                //puts the thread to sleep - wherever it is invoked
                Thread.sleep(1000); //for 1000ms/1s
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
    - printing will be in random order
*/