// Name: Abhijeet Singh
// Student ID: 1207508
// Assignment Number: 2
// Question Number: 2

// Description:
// This program defines a custom List class which emulates some basic list operations
// such as adding an item, deleting an item by index or value, getting an item by position,
// finding the position of an item, and fetching the head and tail of the list.
// The list is initialized from a comma-delimited string and operations are demonstrated in the main method.

import java.util.ArrayList;
import java.util.Arrays;

public class List {
    private ArrayList<String> items;


    public List(String input) {
        items = new ArrayList<>(Arrays.asList(input.split(",")));
    }


    public void addItem(Object o) {
        items.add(o.toString());
    }

    // egt an item at a specific position
    public String getItem(int position) {
        if (position >= 0 && position < items.size()) {
            return items.get(position);
        } else {
            throw new IndexOutOfBoundsException("Invalid position.");
        }
    }

    // Delete an item at a specific position
    public void deleteItem(int position) {
        if (position >= 0 && position < items.size()) {
            items.remove(position);
        } else {
            throw new IndexOutOfBoundsException("Invalid position.");
        }
    }

    // delete an item by value
    public void deleteItem(String item) {
        items.remove(item);
    }

    // get the position of an item by value
    public int getPosition(String item) {
        return items.indexOf(item);
    }

    // get the first element (head) of the list
    public String getHead() {
        if (!items.isEmpty()) {
            return items.get(0);
        } else {
            return null;
        }
    }

    // get the tail of the list all but the first element
    public List getTail() {
        if (items.size() > 1) {
            String tailItems = String.join(",", items.subList(1, items.size()));
            return new List(tailItems);
        } else {
            return new List("");
        }
    }


    public int length() {
        return items.size();
    }

    // convert the list to a comma-delimited string
    @Override
    public String toString() {
        return String.join(",", items);
    }


    public static void main(String[] args) {
        List myList = new List("a,b,c,d,12,dog");

        System.out.println("Initial list: " + myList);

        myList.addItem("cat");
        System.out.println("After adding 'cat': " + myList);

        System.out.println("Item at position 2: " + myList.getItem(2));

        myList.deleteItem(3);
        System.out.println("After deleting item at position 3: " + myList);

        myList.deleteItem("dog");
        System.out.println("After deleting 'dog': " + myList);

        System.out.println("Position of 'b': " + myList.getPosition("b"));

        System.out.println("Head of the list: " + myList.getHead());

        System.out.println("Tail of the list: " + myList.getTail());

        System.out.println("Length of the list: " + myList.length());
    }
}
