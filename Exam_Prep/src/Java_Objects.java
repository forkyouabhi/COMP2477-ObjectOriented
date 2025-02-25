import java.util.Scanner;
class Java_Objects {

    static String employee_name;
    static float employee_salary;

    static void setEmployee(String employee_name, float employee_salary) {
        Java_Objects.employee_name = employee_name ;
        Java_Objects.employee_salary = employee_salary;
    }
    static void getEmployee(String employee_name, float employee_salary) {
        System.out.println(employee_name);
        System.out.println(employee_salary);
    }

    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter the employee name: ");
    employee_name = input.nextLine();
    System.out.println("Enter the employee Salary: ");
    employee_salary = input.nextFloat();
    setEmployee(employee_name, (int) employee_salary);
    getEmployee(employee_name, (int) employee_salary);
    }
}
