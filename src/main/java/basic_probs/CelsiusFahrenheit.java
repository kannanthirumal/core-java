package basic_probs;

import java.util.Scanner;

public class CelsiusFahrenheit {
    public static void main(String[] args) {
        double fahrenheit;
        double celsius;

        System.out.println("Choose: \n 1. Fahrenheit to Celsius \n 2. Celsius to Fahrenheit");
        System.out.println("Enter your choice: ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.println("Enter the temperature in Fahrenheit");
                fahrenheit = input.nextDouble();
                celsius = fahrenheit - 32;
                celsius = celsius * (5.0 / 9);
                System.out.println("Celsius is " + celsius);
            }
            case 2 -> {
                System.out.println("Enter the temperature in Celsius");
                celsius = input.nextDouble();
                fahrenheit = (celsius * 9) / 5;
                fahrenheit = fahrenheit + 32;
                System.out.println("Fahrenheit is " + fahrenheit);
            }
            default -> System.out.println("Invalid choice");
        };
    }
}
