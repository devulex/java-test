package algorithms.sorting.quicksort;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * QuickSort - Быстрая сортировка
 * <p>
 * https://ru.wikipedia.org/wiki/%D0%91%D1%8B%D1%81%D1%82%D1%80%D0%B0%D1%8F_%D1%81%D0%BE%D1%80%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%BA%D0%B0
 * <p>
 * Сложность	Наилучший случай                                                    В среднем       Наихудший случай
 * Время        O(n log n) (обычное разделение) или O(n) (разделение на 3 части)    O(n log n)      O(n2)
 * Память
 * <p>
 * Разработан английским информатиком Чарльзом Хоаром во время его работы в МГУ в 1960 году.
 *
 * @author Aleksandr Uhanov
 * @since 2018-01-29
 */
public class QuickSort {

    public static void main(String... args) {
        int[] array = {9, 0, -2, 89, 1, 2, 3, -3, -99, 6};
        quicksort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quicksort(int[] a, int low, int high) {
        int i = low;
        int j = high;

        int pivot = a[low + (high - low) / 2];

        while (i <= j) {
            while (a[i] < pivot) i++;
            while (a[j] > pivot) j--;

            if (i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }

            if (low < j) quicksort(a, low, j);
            if (i < high) quicksort(a, i, high);
        }
    }
}
