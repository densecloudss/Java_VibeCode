import java.util.Scanner;

class mailHelper {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        String mailSupportName = scanner.nextLine();
        int inboxCounter = scanner.nextInt();
        System.out.println("Привет, " + userName + ", это твой помощник" + mailSupportName + "\nУ тебя " +  inboxCounter + " новых писем.");
    }
}
