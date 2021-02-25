package algorithms.misc.factorial;

import java.util.stream.Stream;

/**
 * Факториал
 * <p>
 * !0 = 1
 * !1 = 1
 * !2 = 2
 * !3 = 6
 * !4 = 24
 * !5 = 120
 * !6 = 720
 *
 * @author Aleksandr Uhanov
 * @since 2018-02-02
 */
public class Factorial {

    public static void main(String... args) {
        for (int i = 0; i < 6; i++) {
            System.out.println("!" + i + " = " + factRecursive(i));
            System.out.println("!" + i + " = " + factIterative(i));
            System.out.println("!" + i + " = " + factFunctional(i));
        }
    }

    private static long factRecursive(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Incorrect input parameter");
        }
        return (num == 0) ? 1 : num * factRecursive(num - 1);
    }

    private static long factIterative(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Incorrect input parameter");
        }
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    private static long factFunctional(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Incorrect input parameter");
        }
        return Stream.iterate(1, n -> n + 1).limit(num).reduce((n1, n2) -> n1 * n2).orElse(1);
    }
}
