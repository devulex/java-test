package concurrent;

/**
 * Deadlock (Взаимная блокировка)
 *
 * @author Aleksandr Uhanov
 * @since 2018-02-06
 */
public class Deadlock {
    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s" + " поклонился мне!%n", this.name, bower.getName());
            bower.bowBack(bower);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s" + " поклонился мне!%n", this.name, bower.getName());
        }
    }

    public static void main(String... args) {
        final Friend alice = new Friend("Alice");
        final Friend bob = new Friend("Bob");
        new Thread(() -> alice.bow(bob)).start();
        new Thread(() -> bob.bow(alice)).start();
    }
}
