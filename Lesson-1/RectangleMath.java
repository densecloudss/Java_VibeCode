import java.util.Scanner;

public class RectangleMath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Float length = scanner.nextFloat();
        Float width = scanner.nextFloat();
        Float perimetr = (length + width) * 2;
        Float area = length * width;
        System.out.println(area);
        System.out.println(perimetr);
    }

}
