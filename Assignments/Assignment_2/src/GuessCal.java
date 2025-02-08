// Name: Abhijeet Singh
// Student ID: 1207508
// Assignment Number: 2
// Question Number: 1

// Description:
// This program calculates the maximum number of guesses required to guess a number
// between 1 and a positive integer N using a binary search strategy.
// It uses the formula log2(N) rounded up to determine the number of guesses needed.

import java.util.Scanner;

public class GuessCal {

    private static int calculateGuesses(int n) {

        return (int) Math.ceil(Math.log(n) / Math.log(2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter a positive integer N: ");
        int n = scanner.nextInt();


        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            int guesses = calculateGuesses(n);
            System.out.println("It will take at most " + guesses + " guesses to guess a number between 1 and " + n + ".");
        }

        scanner.close();
    }
}
