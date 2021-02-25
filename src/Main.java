public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(getTimeAngle(0, 10));
        } catch (IllegalArgumentException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }

        System.out.println(Thread.currentThread().getId());

    }

    /**
     * Получить угол в градусах по времени
     *
     * @param hour   часы
     * @param minute минуты
     * @return угол между стрелками часов в градусах
     */
    public static double getTimeAngle(int hour, int minute) throws IllegalArgumentException {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("Укажите часы в диапазоне от 0 до 23");
        }
        if (minute < 0 || minute >= 59) {
            throw new IllegalArgumentException("Укажите минуты в диапазоне от 0 до 59");
        }
        if (hour >= 12) {
            hour = hour - 12;
        }
        int angleMinutes = 360 / 60 * minute;
        int angleHours = 360 / 12 * hour;

        return Math.abs(angleMinutes - (angleHours + 0.25 * angleMinutes));
    }
}
