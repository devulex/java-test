package algorithms.search.binarysearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Binary search
 *
 * Сложность log n
 *
 * @author Aleksandr Uhanov
 * @since 2017-12-17
 */
public class BinarySearch {

    public static void main(String... args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/algorithms/binarysearch/input.txt"));
        int size = scanner.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = scanner.nextInt();
        }
        int key = scanner.nextInt();
        System.out.println(binarySearch(input, key, 0, size - 1));
        System.out.println(Arrays.binarySearch(input, key));
    }

    public static int binarySearch(int[] array, int key, int low, int high) {
        int middle = (low + high) / 2;

        if (high < low) {
            return -1;
        }

        if (key == array[middle]) {
            return middle;
        } else if (key < array[middle]) {
            return binarySearch(array, key, low, middle - 1);
        } else {
            return binarySearch(array, key, middle + 1, high);
        }
    }
}
