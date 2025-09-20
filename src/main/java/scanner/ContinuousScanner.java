package scanner;

import java.util.Scanner;

public class ContinuousScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the nos to calculate sum");

        /*
            as long as i'm providing int - it will calculate sum
            if I provide a diff datatype - it will stop reading and print sum
         */
        int sum = 0;
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            sum += number;
        }

        System.out.println("The sum is " + sum);
    }
}
