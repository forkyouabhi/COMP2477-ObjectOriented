/**
 * Name: Abhijeet Singh
 * Student ID: 1207508
 * Assignment: Lab Acitivity 1
 * 
 * Description:
 * This program reads 5 numbers between 1 and 30 from the user and displays a bar chart using asterisks (*).
 * Each bar corresponds to the value of the entered number.
 * 
 * How to Run:
 * 1. Compile the program using: javac BarChartDisplay.java or opening through IntelliJ IDEA.
 * 2. Run the program using: java BarChartDisplay
 * 3. Enter 5 numbers between 1 and 30 as prompted.
 * 4. View the bar chart displayed in the console.
 */
package Lab_1 ;
 import java.util.Scanner;

 public class BarChartDisplay {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int[] numbers = new int[5];
 
         System.out.println("Enter 5 numbers between 1 and 30:");
         
         for (int i = 0; i < 5; i++) {
             int input;
             do {
                 System.out.print("Number " + (i + 1) + ": ");
                 input = scanner.nextInt();
                 if (input < 1 || input > 30) {
                     System.out.println("Please enter a number between 1 and 30.");
                 }
             } while (input < 1 || input > 30);
             
             numbers[i] = input;
         }
 
         System.out.println("\nBar Chart:");
         for (int number : numbers) {
             for (int j = 0; j < number; j++) {
                 System.out.print("*");
             }
             System.out.println();
         }
 
         scanner.close();
     }
 }
 