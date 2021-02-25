package concurrent;

/**
 * Запуск потока двумя способами
 */
public class ThreadTest {

    public static void main(String... args) {
        CarThread carThread = new CarThread();
        carThread.run();

        try {
            carThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("---");

        Runnable carRunnable = new CarRunnable();
        new Thread(carRunnable).start();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
                System.out.println("Поток 3 работает");
            }
        }
        ).start();
    }
}

/**
 * Наследование от класса Thread
 */
class CarThread extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            System.out.println("Поток 1 работает");
        }
    }
}

/**
 * Реализация интерфейса Runnable
 */
class CarRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Поток 2 запущен");
    }
}
