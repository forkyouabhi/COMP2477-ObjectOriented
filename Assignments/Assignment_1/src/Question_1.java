import java.util.Scanner;

public class Q1 {
    
    public static String getDayOfWeek(int day) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int startDay = 3; // January 1, 2025 is Wednesday
        return days[(startDay + (day - 1)) % 7];
    }

    
    public static int getDay(int month, int dayOfMonth) {
        int[] monthLength = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 2025 is not a leap year
        int dayOfYear = 0;

        for (int i = 0; i < month - 1; i++) {
            dayOfYear += monthLength[i];
        }
        return dayOfYear + dayOfMonth;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day, month, dayOfMonth;

        // Validate and get birthday input
        do {
            System.out.print("Enter your birthday (between 1-365): ");
            day = sc.nextInt();
        } while (day < 1 || day > 365);

        System.out.println("Your birthday falls on a " + getDayOfWeek(day) + " in 2025.\n");

        // Validate and get month input
        do {
            System.out.print("Enter the month number (1-12): ");
            month = sc.nextInt();
        } while (month < 1 || month > 12);

        // Validate and get day-of-month input
        int[] monthLength = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        do {
            System.out.print("Enter the day of the month (1-" + monthLength[month - 1] + "): ");
            dayOfMonth = sc.nextInt();
        } while (dayOfMonth < 1 || dayOfMonth > monthLength[month - 1]);

        System.out.printf("Day of the year: %d%n", getDay(month, dayOfMonth));
        
        sc.close(); 
    }
}
