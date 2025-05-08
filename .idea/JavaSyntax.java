public class JavaSyntax {
    public static void main(String[] args) {
        // 1. Объявление переменных
        // Примитивные типы данных
        int number = 42;           // целое число
        double decimal = 3.14;     // число с плавающей точкой
        boolean isTrue = true;     // логический тип
        char symbol = 'A';         // символ
        
        // Ссылочные типы данных
        String text = "Привет";    // строка
        Integer numberObj = 42;    // объект-обертка для int
        
        // 2. Массивы
        int[] numbers = {1, 2, 3, 4, 5};  // массив чисел
        String[] words = new String[3];   // пустой массив строк
        
        // 3. Условные операторы
        if (number > 40) {
            System.out.println("Число больше 40");
        } else if (number == 40) {
            System.out.println("Число равно 40");
        } else {
            System.out.println("Число меньше 40");
        }
        
        // 4. Циклы
        // for
        for (int i = 0; i < 3; i++) {
            System.out.println("Итерация " + i);
        }
        
        // while
        int count = 0;
        while (count < 3) {
            System.out.println("Счетчик: " + count);
            count++;
        }
        
        // 5. Методы
        int sum = addNumbers(5, 3);
        System.out.println("Сумма: " + sum);
        
        // 6. Операторы
        int a = 10;
        int b = 5;
        
        // Арифметические операторы
        System.out.println("a + b = " + (a + b));  // сложение
        System.out.println("a - b = " + (a - b));  // вычитание
        System.out.println("a * b = " + (a * b));  // умножение
        System.out.println("a / b = " + (a / b));  // деление
        System.out.println("a % b = " + (a % b));  // остаток от деления
        
        // Операторы сравнения
        System.out.println("a > b: " + (a > b));   // больше
        System.out.println("a < b: " + (a < b));   // меньше
        System.out.println("a == b: " + (a == b)); // равно
        System.out.println("a != b: " + (a != b)); // не равно
        
        // 7. Тернарный оператор
        String result = (a > b) ? "a больше b" : "a не больше b";
        System.out.println(result);
    }
    
    // Пример метода
    public static int addNumbers(int a, int b) {
        return a + b;
    }
} 