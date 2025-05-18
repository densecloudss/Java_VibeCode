import java.util.Scanner;

class Birthday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        System.out.println(day + ":" + month + ":" +  year);
    }
}