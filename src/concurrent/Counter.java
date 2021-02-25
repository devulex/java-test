package concurrent;

/**
 * Потокозащищенный счетчик, использующий синхронизацию. Алгоритм блокирующий
 *
 * @author Aleksandr Uhanov
 * @since 2018-02-07
 */
public final class Counter {
    private long value = 0;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        return ++value;
    }
}
