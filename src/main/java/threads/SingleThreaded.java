package threads;

public class SingleThreaded {
    public static void main(String[] args) {
        SingleThreaded singleThreaded = new SingleThreaded();
        singleThreaded.printNumber();

        for (int j = 1; j <= 200; j++) {
            //System.out.print("j: " + j + "\t");
            System.out.println("j: " + j);
        }
    }

    private void printNumber () {
        for (int i = 1; i <= 200; i++) {
            //System.out.print("i: " + i + "\t");
            System.out.println("i: " + i);
        }
    }
}
