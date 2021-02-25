package algorithms.sorting.bubblesort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Bubblesort
 * <p>
 * https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%BF%D1%83%D0%B7%D1%8B%D1%80%D1%8C%D0%BA%D0%BE%D0%BC
 * <p>
 * Сложность	Наилучший случай	В среднем	Наихудший случай
 * Время        O(n)                O(n2)       O(n2)
 * Память       O(1)                O(1)        O(1)
 *
 * @author Aleksandr Uhanov
 * @since 2018-01-22
 */
public class BubbleSort {

    public static void main(String... args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/algorithms/sorting/bubblesort/input.txt"));
        int size = scanner.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.println("");
        for (int number : input) {
            System.out.print(number + " ");
        }
        bubblesort(input);
        System.out.println("");
        for (int number : input) {
            System.out.print(number + " ");
        }
    }

    private static void bubblesort(int[] array) {
        int n = array.length;
        for (int j = 0; j < n - 1; j++) {
            boolean swapped = false;
            for (int i = 0; i < n - 1 - j; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
