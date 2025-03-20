/**
 * Name: Abhijeet Singh
 * Student ID: 1207508
 * Assignment: 3
 * Question: 1
 *
 * Description:
 * This program implements a Document class hierarchy with Email and File subclasses.
 * The Document class serves as the base class with a 'text' field and methods to get/set it.
 * The Email class extends Document with sender, recipient, and title fields.
 * The File class extends Document with a pathname field.
 * Both subclasses override the toString method to include their specific fields.
 *
 * A ContainsKeyword method demonstrates polymorphism by searching any Document object
 * for a specified keyword.
 *
 * To run the program:
 * 1. Compile: javac DocumentTest.java
 * 2. Run: java DocumentTest
 *
 * The program creates sample Email and File objects and tests the ContainsKeyword method.
 */


import java.util.ArrayList;

// Base Document class
class Document {
    protected String text;

    // Default constructor
    public Document() {
        this.text = "";
    }

    // Set text method
    public void setText(String text) {
        this.text = text;
    }

    // ToString method
    public String toString() {
        return text;
    }
}

// Email class inheriting from Document
class Email extends Document {
    private String sender;
    private String recipient;
    private String title;

    // Constructor
    public Email(String sender, String recipient, String title, String body) {
        this.sender = sender;
        this.recipient = recipient;
        this.title = title;
        this.text = body;
    }

    // Accessor methods
    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getTitle() {
        return title;
    }

    // Mutator methods
    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Overridden toString method
    @Override
    public String toString() {
        return "From: " + sender +
                "\nTo: " + recipient +
                "\nTitle: " + title +
                "\nBody: " + text;
    }
}

// File class inheriting from Document
class File extends Document {
    private String pathname;

    // Constructor
    public File(String pathname, String content) {
        this.pathname = pathname;
        this.text = content;
    }

    // Accessor method
    public String getPathname() {
        return pathname;
    }

    // Mutator method
    public void setPathname(String pathname) {
        this.pathname = pathname;
    }

    // Overridden toString method
    @Override
    public String toString() {
        return "Pathname: " + pathname +
                "\nContent: " + text;
    }

    // Static method to check for keyword
    public static boolean ContainsKeyword(Document docObject, String keyword) {
        return docObject.toString().indexOf(keyword, 0) >= 0;
    }
}

// Main class to test the implementation
public class DocumentTest {
    public static void main(String[] args) {
        // Create sample Email objects
        Email email1 = new Email("john@example.com", "jane@example.com",
                "Meeting Reminder", "Let's meet tomorrow at 2 PM.");
        Email email2 = new Email("hr@company.com", "employee@company.com",
                "Job Offer", "Congratulations on your new position!");

        // Create sample File objects
        File file1 = new File("/documents/report.txt", "Annual financial report for 2024.");
        File file2 = new File("/projects/notes.txt", "Project meeting notes and action items.");

        // Test ContainsKeyword method
        System.out.println("Email 1 contains 'meet': " +
                File.ContainsKeyword(email1, "meet"));
        System.out.println("File 1 contains 'financial': " +
                File.ContainsKeyword(file1, "financial"));

        // Print full objects
        System.out.println("\nEmail 1:\n" + email1);
        System.out.println("\nFile 2:\n" + file2);
    }
}