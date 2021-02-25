package algorithms.sorting.bogosort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Bogosort
 *
 * @author Aleksandr Uhanov
 * @since 2018-01-21
 */
public class BogoSort {

    private static final Random random = new Random();

    public static void main(String... args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/algorithms/sorting/bogosort/input.txt"));
        int size = scanner.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = scanner.nextInt();
        }
        for (int i : input) {
            System.out.print(i + " ");
        }
        bogosort(input);
        System.out.println();
        for (int i : input) {
            System.out.print(i + " ");
        }
    }

    private static void bogosort(int[] array) {
        while (!isSorted(array)) {
            shuffle(array);
        }
    }

    private static void shuffle(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = random.nextInt(Integer.MAX_VALUE) % array.length;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
