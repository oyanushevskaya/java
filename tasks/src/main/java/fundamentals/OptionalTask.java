package fundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class OptionalTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        int n = sc.nextInt();
        int arrayInt[] = new int[n];
        for (int i = 0; i < n; i++) {
            arrayInt[i] = sc.nextInt();
        }
        for (int i : arrayInt) {
            System.out.print(i + " ");
        }

        //1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
        int max = arrayInt[0], min = arrayInt[0];
        for (int i = 0; i < n; i++) {
            if (arrayInt[i] > max) {
                max = arrayInt[i];
            }
            if (arrayInt[i] < min) {
                min = arrayInt[i];
            }
        }

        System.out.println("\nMax = " + max + " length = " + String.valueOf(max).length());
        System.out.println("Min = " + min + " length = " + String.valueOf(min).length());

        //2. Вывести числа в порядке возрастания (убывания) значений их длины.
        Arrays.sort(arrayInt);
        System.out.println("\nModified arrays: ");
        for (int i: arrayInt) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        for (int i = n-1; i >=0 ; i--) {
            System.out.print(arrayInt[i] + " ");
        }


        //3. Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
        int sum = 0, average = 0;
        for (int i = 0; i < n; i++) {
            sum += arrayInt[i];
            average = sum/n;
        }
        System.out.println("\n\nAverage length = " + average);

        System.out.println("\nNumbers more average length: ");
        for (int i = 0; i < n; i++) {
            if (arrayInt[i] > average) {
                System.out.println(arrayInt[i] + " length = " + String.valueOf(arrayInt[i]).length());
            }
        }

        System.out.println("\nNumbers less average length: ");
        for (int i = 0; i < n; i++) {
            if (arrayInt[i] < average) {
                System.out.println(arrayInt[i] + " length = " + String.valueOf(arrayInt[i]).length());
            }
        }

    }
}
