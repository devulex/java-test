package algorithms.search.linear;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Linear search
 *
 * @author Aleksandr Uhanov
 * @since 2017-12-17
 */
public class LinearSearch {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/algorithms/search/linear/input.txt"));
        int size = scanner.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = scanner.nextInt();
        }
        int element = scanner.nextInt();

        System.out.println("Position of element " + search(input, element));
    }

    private static int search(int[] input, int element) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == element) {
                return i;
            }
        }
        return -1;
    }
}
