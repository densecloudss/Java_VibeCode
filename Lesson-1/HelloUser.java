import java.util.Scanner;

public class HelloUser {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         System.out.println("Hey, write your name right here: ");
         String text = scanner.nextLine();
         System.out.println("Wasup, " + text);
     }
}
