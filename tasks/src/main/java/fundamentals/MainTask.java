package fundamentals;

import java.util.Scanner;

public class MainTask {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //1. Приветствовать любого пользователя при вводе его имени через командную строку.
        System.out.print("Enter your name: ");
        String name = sc.next();
        System.out.println("Hello, " + name);

        //2. Отобразить в окне консоли аргументы командной строки в обратном порядке.
        System.out.println("Array");
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }
        System.out.println("\nReverse array");
        for (int i = args.length-1; i >= 0; i--) {
            System.out.print(args[i] + " ");
        }

        //3. Вывести заданное количество заданных чисел с переходом и без перехода на новую строку.
        System.out.print("\nn = ");
        int n = sc.nextInt();
        int random[] = new int[n];
        for(int i = 0; i < n; i++){
            random[i] = (int)(Math.random()*10);
            System.out.println(random[i]);
        }
        for (int i: random) {
            System.out.print(i + " ");
        }

        //4. Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.
        int sum = 0;
        int mult = 1;
        System.out.println("\nEnter numbers: ");
        for (int i = 0; i < 6; i++) {
            args[i] = sc.next();
            sum += Integer.valueOf(args[i]);
            mult *= Integer.valueOf(args[i]);
        }
        for (String i: args) {
            System.out.print(i + " ");
        }
        System.out.println("\nSum = " + sum);
        System.out.println("Multiplication = " + mult);

        //5. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.
        System.out.println("Enter month number: ");
        int month = sc.nextInt();
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
}
