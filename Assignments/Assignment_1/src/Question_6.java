import java.util.Scanner;

public class Question_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sequence of consecutive numbers:");
        System.out.print("Enter the first number: ");
        int previousNumber = scanner.nextInt();
        boolean isConsecutive = true;

        while (isConsecutive) {
            System.out.print("Enter the next number: ");
            int currentNumber = scanner.nextInt();

            if (currentNumber == previousNumber + 1) {
                previousNumber = currentNumber;
            } else {
                isConsecutive = false;
                System.out.println("The number " + currentNumber + " is not consecutive.");
            }
        }

        System.out.println("Sequence ended.");
        scanner.close();
    }
}
