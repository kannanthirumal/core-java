package scanner;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the student id: ");
        int id = scanner.nextInt();

        System.out.println("Enter the student name: ");
        String name = scanner.next();

        System.out.println("Enter the student marks: ");
        double score = scanner.nextDouble();

        System.out.println("Student Details");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Score: " + score);
    }
}
