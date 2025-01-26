import java.util.Scanner;

public class Question_7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the name of the substance: ");
        String substanceName = scanner.nextLine();


        System.out.print("Enter the half-life of the substance (in years): ");
        double halfLife = scanner.nextDouble();


        double initialAmount = 100.0;
        double currentAmount = initialAmount;
        int years = 0;


        while (currentAmount >= 2.0) {
            currentAmount /= 2;
            years += halfLife;
        }


        System.out.println("\nSubstance: " + substanceName);
        System.out.println("Half-life: " + halfLife + " years");
        System.out.println("It will take approximately " + years + " years for less than 2% of the substance to remain.");

        scanner.close();
    }
}
