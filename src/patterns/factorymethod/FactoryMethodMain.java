package patterns.factorymethod;

/**
 * Фабричный метод
 *
 * @author Aleksandr Uhanov
 * @since 2018-02-05
 */

public class FactoryMethodMain {
    public static void main(String... args) {
        Printer printer = new FactoryUpper().createPrinter();
        printer.print();
    }
}

interface Printer {
    void print();
}

class LowerPrinter implements Printer {
    @Override
    public void print() {
        System.out.println("LowerPrinter");
    }
}

class UpperPrinter implements Printer {
    @Override
    public void print() {
        System.out.println("UpperPrinter");
    }
}

abstract class Factory {
    abstract public Printer createPrinter();
}

class FactoryLower extends Factory {
    @Override
    public Printer createPrinter() {
        return new LowerPrinter();
    }
}

class FactoryUpper extends Factory {
    @Override
    public Printer createPrinter() {
        return new UpperPrinter();
    }
}
