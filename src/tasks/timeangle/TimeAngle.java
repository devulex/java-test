package tasks.timeangle;

/**
 * Угол между стрелками
 *
 * @author Aleksandr Uhanov
 * @since 2018-02-03
 */
public class TimeAngle {

    public static void main(String... args) {
        System.out.println(calcTimeAngle(10, 47));
    }

    private static double calcTimeAngle(int hours, int minutes) {
        if (hours < 0 || hours > 23) {
            throw new IllegalArgumentException("Incorrect param hours");
        }
        if (minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Incorrect param minutes");
        }
        if (hours > 12) {
            hours = hours - 12;
        }
        int minutesAngle = minutes * 6;
        double hoursAngle = hours * 30 + 0.5d * minutes;
        return Math.abs(minutesAngle - hoursAngle);
    }
}
