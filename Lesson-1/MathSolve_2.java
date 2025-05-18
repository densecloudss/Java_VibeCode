import java.util.Scanner;

public class MathSolve_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double squareX = Math.pow(x, 2);
        Double result = 5 * squareX + 2 * x + 11;
        System.out.println(result);
    }
}
