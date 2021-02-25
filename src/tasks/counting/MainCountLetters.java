package tasks.counting;

import java.util.HashMap;
import java.util.Map;

/**
 * Задача на подсчет количества различных символов в строке
 *
 * @author Aleksandr Uhanov
 * @since 2017-11-29
 */
public class MainCountLetters {

    public static void main(String[] args) {
        System.out.println(stringTransform("aaabcaaabc"));
        System.out.println(stringTransform(null));
    }

    public static String stringTransform(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Строка не может быть пустая");
        }
        Map<Character, Integer> letters = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char key = input.charAt(i);
            if (letters.get(key) == null) {
                letters.put(key, 1);
            } else {
                letters.put(key, letters.get(key) + 1);
            }
        }
        StringBuilder output = new StringBuilder();
        letters.forEach((k, v) -> {
            output.append(v).append(k);
        });
        return output.toString();
    }
}
