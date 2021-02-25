package algorithms.misc;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(21));
    }

    public static int fibonacci(int number) {
        var i = 0;
        var number1 = 0;
        var number2 = 1;
        while (true) {
            var temp = number1 + number2;
            number1 = number2;
            number2 = temp;
            if (number2 == number) {
                return i + 1;
            }
            if (number2 > number) {
                return -1;
            }
            i++;
        }
    }
}
