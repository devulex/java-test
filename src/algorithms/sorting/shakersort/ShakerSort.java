package algorithms.sorting.shakersort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Shakersort - Сортировка перемешиванием
 * <p>
 * https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0_%D0%BF%D0%B5%D1%80%D0%B5%D0%BC%D0%B5%D1%88%D0%B8%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5%D0%BC
 * http://sorting.valemak.com/cocktail/
 * <p>
 * Сложность	Наилучший случай	В среднем	Наихудший случай
 * Время        O(n)                O(n2)       O(n2)
 * Память       O(1)                O(1)        O(1)
 *
 * @author Aleksandr Uhanov
 * @since 2018-01-22
 */
public class ShakerSort {

    public static void main(String... args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/algorithms/sorting/shakersort/input.txt"));
        int size = scanner.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.println("");
        for (int number : input) {
            System.out.print(number + " ");
        }
        shakersort(input);
        System.out.println("");
        for (int number : input) {
            System.out.print(number + " ");
        }
    }

    private static void shakersort(int[] array) {
        int left = 0;
        int right = array.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
            left++;
        } while (left < right);
    }
}
