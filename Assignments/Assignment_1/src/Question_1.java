import java.util.Scanner;

public class Question_1 {


    public static double calculateCharges(double hours) {
        double charge = 2.00;
        if (hours > 3) {
            charge += Math.ceil(hours - 3) * 0.50;
        }
        return Math.min(charge, 10.00);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalReceipts = 0.0;
        char anotherCustomer = 'y';

        System.out.println("Welcome to the Parking Garage!");

        while (anotherCustomer == 'y') {
            System.out.print("Enter the number of hours parked for the customer: ");
            double hours = scanner.nextDouble();


            if (hours < 0 || hours > 24) {
                System.out.println("Invalid number of hours. Please enter a value between 0 and 24.");
                continue;
            }


            double charge = calculateCharges(hours);
            System.out.printf("Charge for this customer: $%.2f%n", charge);


            totalReceipts += charge;

            System.out.print("Is there another customer? (y/n): ");
            anotherCustomer = scanner.next().toLowerCase().charAt(0);
        }


        System.out.printf("Total receipts for the day: $%.2f%n", totalReceipts);
        scanner.close();
    }
}
