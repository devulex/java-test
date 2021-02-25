package algorithms.misc.reverse;

/**
 * Инверсия строки
 *
 * @author Aleksandr Uhanov
 * @since 2018-02-02
 */
public class StringReverse {

    public static void main(String... args) {
        String str = "abcdef";
        System.out.println("input  = " + str);
        System.out.println("output = " + reverse(str));
    }


    private static String reverse(String s) {
        char[] array = s.toCharArray();
        StringBuilder result = new StringBuilder(s.length());
        for (int i = 0; i < array.length; i++) {
            result.append(array[array.length - 1 - i]);
        }
        return result.toString();
    }
}
