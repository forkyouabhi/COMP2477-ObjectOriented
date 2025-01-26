public class Question_2 {


    public static char shift(char c, int n) {
        if (!Character.isLetter(c)) {
            return c;
        }


        char base = Character.isLowerCase(c) ? 'a' : 'A';


        return (char) ((c - base + n) % 26 + base);
    }

    public static void main(String[] args) {
        // Examples
        System.out.println(shift('a', 2)); // Output: c
        System.out.println(shift('y', 2)); // Output: a
        System.out.println(shift('A', 5)); // Output: F
        System.out.println(shift('Z', 1)); // Output: A
        System.out.println(shift('!', 2)); // Output: !
    }
}
