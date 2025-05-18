import java.util.Scanner;

public class MathSolve_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int squareX = (int) Math.pow(num, 2);
        int cubeX = (int) Math.pow(num, 3);
        System.out.print(num + " ");
        System.out.print(squareX + " ");
        System.out.print(cubeX);
    }
}
