public class Question_4 {

    public static void main(String[] args) {
        System.out.println("N\tSQUARE\tCUBE");

        for (int n = 1; n <= 5; n++) {
            int square = n * n;
            int cube = n * n * n;
            System.out.printf("%d\t%d\t%d%n", n, square, cube);
        }
    }
}
