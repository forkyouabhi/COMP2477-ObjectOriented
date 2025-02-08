import java.util.Scanner;

public class Question_8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the first value: ");
        int value1 = scanner.nextInt();

        System.out.print("Enter the second value: ");
        int value2 = scanner.nextInt();

        System.out.print("Enter the third value: ");
        int value3 = scanner.nextInt();

        System.out.print("Enter the fourth value: ");
        int value4 = scanner.nextInt();

        // find the maximum value to determine the height of the bars
        int maxValue = Math.max(Math.max(value1, value2), Math.max(value3, value4));

        // loop through each level (from max down to 1)
        for (int i = maxValue; i >= 1; i--) {
            // print stars for each value that is greater than or equal to the current level
            printBar(value1, i);
            printBar(value2, i);
            printBar(value3, i);
            printBar(value4, i);

            // moove to the next line after each row of stars
            System.out.println();
        }

        // print the horizontal line after the bars
        System.out.println("-------------");

        scanner.close();
    }

    // helps function to print a bar for each value
    private static void printBar(int value, int level) {
        if (value >= level) {
            System.out.print("** ");
        } else {
            System.out.print("   ");
        }
    }
}
