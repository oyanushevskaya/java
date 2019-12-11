package fundamentals;

import java.util.Random;
import java.util.Scanner;

public class MainTask {
    private static Scanner scanner = new Scanner(System.in);

    //1. Приветствовать любого пользователя при вводе его имени через командную строку.
    static String welcomeUser() {
        System.out.print("Enter your name: ");
        String nameUser = scanner.next();
        return "Hello, " + nameUser;
    }
    //2. Отобразить в окне консоли аргументы командной строки в обратном порядке.
    static void reverseArray(String[] args) {
        System.out.println("Array");
        for (String arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println("\nReverse array");
        for (int i = args.length-1; i >= 0; i--) {
            System.out.print(args[i] + " ");
        }
    }
    //3. Вывести заданное количество заданных чисел с переходом и без перехода на новую строку.
    static void printRandomNumber() {
        System.out.print("\nEnter size of the array  = ");
        Random random = new Random();
        int sizeArray = scanner.nextInt();
        int[] randomArray = new int[sizeArray];
        for(int i = 0; i < sizeArray; i++){
            randomArray[i] = random.nextInt(10);
            System.out.println(randomArray[i]);
        }
        for (int i: randomArray) {
            System.out.print(i + " ");
        }
    }

    //4. Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.
    static void operationWithNumbers(String[] args) {
        int sum = 0;
        int mult = 1;
        if (args.length == 0) {
            System.out.println("\nEnter program arguments ");
        } else
            System.out.println("\nEnter " + args.length + " numbers: ");
        for (int i = 0; i < args.length; i++) {
            args[i] = scanner.next();
            sum += Integer.parseInt(args[i]);
            mult *= Integer.parseInt(args[i]);
        }
        for (String i: args) {
            System.out.print(i + " ");
        }
        System.out.println("\nSum = " + sum);
        System.out.println("Multiplication = " + mult);
    }

    //5. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.
    static void printGivenMonth() {
        System.out.println("Enter month number: ");
        int month = scanner.nextInt();
        String nameMonth;
        switch (month) {
            case 1:
                nameMonth = "January";
                break;
            case 2:
                nameMonth = "February";
                break;
            case 3:
                nameMonth = "March";
                break;
            case 4:
                nameMonth = "April";
                break;
            case 5:
                nameMonth = "May";
                break;
            case 6:
                nameMonth = "June";
                break;
            case 7:
                nameMonth = "July";
                break;
            case 8:
                nameMonth = "August";
                break;
            case 9:
                nameMonth = "September";
                break;
            case 10:
                nameMonth = "October";
                break;
            case 11:
                nameMonth = "November";
                break;
            case 12:
                nameMonth = "December";
                break;
            default:
                nameMonth = "Month not exist";
        }
        System.out.println(nameMonth);
    }


    public static void main(String[] args) {
        System.out.println(welcomeUser());

        reverseArray(args);

        printRandomNumber();

        operationWithNumbers(args);

        printGivenMonth();
    }
}
