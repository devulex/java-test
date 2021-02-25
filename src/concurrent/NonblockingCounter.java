package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Потокозащищенный счетчик. Неблокирующий алгоритм
 *
 * @author Aleksandr Uhanov
 * @since 2018-02-07
 */
public class NonblockingCounter {
    private AtomicInteger value;

    public int getValue() {
        return value.get();
    }

    public int increment() {
        int v;
        do {
            v = value.get();
        } while (!value.compareAndSet(v, v + 1));
        return v + 1;
    }
}
