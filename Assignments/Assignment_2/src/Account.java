/**
 * Name: Abhijeet Singh
 * Student ID: 1207508
 * Assignment Number: 2
 * Question Number: 4
 *
 * Description:
 * This program simulates an ATM system using an Account class. It provides functionalities
 * such as checking balance, withdrawing money, depositing money, and managing multiple accounts.
 *
 * How to Run:
 * - Compile the program using `javac Account.java`
 * - Run the program using `java Account`
 * - Enter an account ID (0-9) to begin transactions.
 * - Follow the prompts to perform operations like balance checks, deposits, and withdrawals.
 * - Enter 4 to exit to the main menu and select a different account if desired.
 */

import java.util.Date;
import java.util.Scanner;

public class Account {
    private int id;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated;

    // No-arg constructor
    public Account() {
        this(0, 0);
    }

    // Constructor with specified id and initial balance
    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    // Get monthly interest rate
    public double getMonthlyInterestRate() {
        return annualInterestRate / 12;
    }

    // Get monthly interest
    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate() / 100;
    }

    // Withdraw amount
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
        }
    }

    // Deposit amount
    public void deposit(double amount) {
        balance += amount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account[] accounts = new Account[10];

        // Initialize 10 accounts with ID 0 to 9 and initial balance of 100
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 100);
        }

        while (true) {
            // Prompt for account ID
            System.out.print("Enter an id: ");
            int id = scanner.nextInt();

            if (id < 0 || id >= accounts.length) {
                System.out.println("Invalid ID. Please try again.");
                continue;
            }

            while (true) {
                // Display main menu
                System.out.println("\nMain menu");
                System.out.println("1: check balance");
                System.out.println("2: withdraw");
                System.out.println("3: deposit");
                System.out.println("4: exit");
                System.out.print("Enter a choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("The balance is " + accounts[id].getBalance());
                        break;
                    case 2:
                        System.out.print("Enter an amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        accounts[id].withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter an amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        accounts[id].deposit(depositAmount);
                        break;
                    case 4:
                        System.out.println("Exiting to ID selection...\n");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

                if (choice == 4) {
                    break;
                }
            }
        }
    }
}
