import java.util.ArrayList;


class PhoneBookEntry {
    private String name;
    private String phoneNumber;


    public PhoneBookEntry(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber;
    }
}


public class PhoneBook {
    public static void main(String[] args) {
        // Create an ArrayList to store phone book entries
        ArrayList<PhoneBookEntry> phoneBook = new ArrayList<>();


        phoneBook.add(new PhoneBookEntry("Alice Johnson", "123-456-7890"));
        phoneBook.add(new PhoneBookEntry("Bob Smith", "987-654-3210"));
        phoneBook.add(new PhoneBookEntry("Charlie Brown", "555-123-4567"));
        phoneBook.add(new PhoneBookEntry("Diana Prince", "444-222-3333"));
        phoneBook.add(new PhoneBookEntry("Ethan Hunt", "777-888-9999"));


        System.out.println("Phone Book Entries:");
        for (PhoneBookEntry entry : phoneBook) {
            System.out.println(entry);
        }
    }
}
