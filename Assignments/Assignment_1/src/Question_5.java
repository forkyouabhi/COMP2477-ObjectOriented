import java.util.Scanner;

public class Question_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Display the menu
            System.out.println("Menu:");
            System.out.println("1. Print a string of N characters.");
            System.out.println("2. Print the triangular multiplication table.");
            System.out.println("3. Print patterns using '#'.");
            System.out.println("4. Exit.");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Call method to print a string of N characters
                    System.out.print("Enter a character: ");
                    char ch = scanner.next().charAt(0);
                    System.out.print("Enter the number of times to print: ");
                    int n = scanner.nextInt();
                    printCharacters(ch, n);
                    break;

                case 2:
                    // Call method to print the multiplication table
                    printMultiplicationTable();
                    break;

                case 3:
                    // Call methods to print patterns
                    System.out.println("Patterns: ");
                    printPatterns();
                    break;

                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 4);

        scanner.close();
    }

    // Method 1: Print a string of N characters
    public static void printCharacters(char ch, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(ch);
        }
        System.out.println();
    }

    // Method 2: Print the multiplication table
    public static void printMultiplicationTable() {
        System.out.println("  1  2  3  4  5  6  7  8  9");
        for (int i = 1; i <= 9; i++) {
            System.out.print(i + " ");
            for (int j = 1; j <= i; j++) {
                System.out.print((i * j) + " ");
            }
            System.out.println();
        }
    }

    // Method 3: Print # Patterns
    public static void printPatterns() {
        int i, j, n = 8;

        // First Pattern (Triangle)
        System.out.println("Pattern 1:");
        for (i = n; i > 0; i--) {
            for (j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (j = 0; j < i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

        // Second Pattern (Reverse Triangle)
        System.out.println("\nPattern 2:");
        for (i = n; i >= 1; i--) {
            for (j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (j = 0; j <= n - i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

        // Hollow Hourglass Pattern
        System.out.println("\nPattern 3:");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (i == j || i + j == n - 1 || i == 0 || i == n - 1) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // "Z" Pattern
        System.out.println("\nPattern 4 (Z):");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (i == 0 || i == n - 1 || i + j == n - 1) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
