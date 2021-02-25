package algorithms.sorting.insertionsort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * InsertionSort - Сортировка простыми вставками
 * <p>
 * http://sorting.valemak.com/insertion/
 *
 * Сложность	Наилучший случай	В среднем	Наихудший случай
 * Время        O(n)                O(n2)       O(n2)
 * Память       O(1)                O(1)        O(1)
 *
 * @author Aleksandr Uhanov
 * @since 2018-01-28
 */
public class InsertionSort {
    public static void main(String... args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/algorithms/sorting/insertionsort/input.txt"));
        int size = scanner.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.println("");
        for (int i : input) {
            System.out.print(i + " ");
        }
        insertionsort(input);
        System.out.println("");
        for (int i : input) {
            System.out.print(i + " ");
        }
    }

    private static void insertionsort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}
