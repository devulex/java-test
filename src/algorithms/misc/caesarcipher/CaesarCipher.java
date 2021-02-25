package algorithms.misc.caesarcipher;

/**
 * Шифр Цезаря
 *
 * @author Aleksandr Uhanov
 * @since 2018-02-02
 */
public class CaesarCipher {

    public static void main(String... args) {
        String input = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        System.out.println("input =  " + input);
        System.out.println("output = " + caesarcipher(input, 3));
    }

    private static String caesarcipher(String msg, int shift) {
        msg = msg.toUpperCase();
        StringBuilder result = new StringBuilder(26);
        for (int i = 0; i < msg.length(); i++) {
            char c = msg.charAt(i);
            if (c < 65 || c > 90) {
                throw new IllegalArgumentException("Incorrect input string at " + c);
            }
            result.append((char) ((c - 65 + shift) % 26 + 65));
        }
        return result.toString();
    }
}
