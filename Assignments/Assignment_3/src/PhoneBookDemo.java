/*
 * Name: Abhijeet Singh
 * Student ID: 1207508
 * Assignment: 3
 * Question: 3
 *
 * Description:
 * This program implements a simple PhoneBook application using an ArrayList.
 * Each contact in the phone book consists of a name and a phone number.
 * The program initializes a few contacts, stores them in an ArrayList,
 * and then displays them using a loop.
 *
 * How to Run:
 * 1. Compile the program using: javac PhoneBookDemo.java
 * 2. Run the program using: java PhoneBookDemo
 */
import java.util.ArrayList;

// PhoneBook class
class PhoneBook {
    private String name;
    private String phoneNumber;

    // Constructor
    public PhoneBook(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Accessor methods
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Mutator methods
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber;
    }
}

// Main class to demonstrate PhoneBook
public class PhoneBookDemo {
    public static void main(String[] args) {
        // Create an ArrayList to store PhoneBook objects
        ArrayList<PhoneBook> phoneDirectory = new ArrayList<>();

        // Create and add PhoneBook objects
        phoneDirectory.add(new PhoneBook("John Doe", "555-1234"));
        phoneDirectory.add(new PhoneBook("Jane Smith", "555-5678"));
        phoneDirectory.add(new PhoneBook("Alice Johnson", "555-9012"));
        phoneDirectory.add(new PhoneBook("Bob Williams", "555-3456"));
        phoneDirectory.add(new PhoneBook("Charlie Brown", "555-7890"));

        // Display contents of each object using a loop
        System.out.println("Phone Directory Contents:");
        for (PhoneBook contact : phoneDirectory) {
            System.out.println(contact);
        }
    }
}