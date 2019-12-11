package fundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class OptionalTask {
    private static Scanner scanner = new Scanner(System.in);
    private static final String LENGTH = " length = ";

    static int[] enterNumbers() {
        System.out.print("Enter size of the array = ");
        int sizeArray = scanner.nextInt();
        int[] arrayInt = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            arrayInt[i] = scanner.nextInt();
        }
        return arrayInt;
    }

    //1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
    static int maxNumber(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    static int minNumber(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    //2. Вывести числа в порядке возрастания (убывания) значений их длины.
    static void sortedArray(int[] array) {
        Arrays.sort(array);
        System.out.println("\nModified arrays: ");
        for (int i: array) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        for (int i = array.length-1; i >=0 ; i--) {
            System.out.print(array[i] + " ");
        }
    }

    //3. Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.\
    static int average;
    static void averageLength(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += String.valueOf(array[i]).length();
        }
        average = sum/array.length;
        System.out.println("\n\nAverage length = " + average);
    }
    static void numbersMoreAverageLength(int[] array) {
        System.out.println("\nNumbers more average length: ");
        for (int i = 0; i < array.length; i++) {
            if (String.valueOf(array[i]).length() > average) {
                System.out.println(array[i] + LENGTH + String.valueOf(array[i]).length());
            }
        }
    }
    static void numbersLessAverageLength(int[] array) {
        System.out.println("\nNumbers less average length: ");
        for (int i = 0; i < array.length; i++) {
            if (String.valueOf(array[i]).length() < average) {
                System.out.println(array[i] + LENGTH + String.valueOf(array[i]).length());
            }
        }
    }

    public static void main(String[] args) {
        int[] arrayOfNumbers = enterNumbers();
        System.out.println("\nMax number = " + maxNumber(arrayOfNumbers) + LENGTH + String.valueOf(maxNumber(arrayOfNumbers)).length());
        System.out.println("\nMin number = " + minNumber(arrayOfNumbers) + LENGTH + String.valueOf(minNumber(arrayOfNumbers)).length());

        sortedArray(arrayOfNumbers);

        averageLength(arrayOfNumbers);

        numbersMoreAverageLength(arrayOfNumbers);
        numbersLessAverageLength(arrayOfNumbers);

    }
}
