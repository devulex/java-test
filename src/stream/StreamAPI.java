package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * StreamAPI
 *
 * @author Aleksandr Uhanov
 * @since 2018-02-04
 */
public class StreamAPI {

    public static void main(String... args) throws IOException {
        Collection<Integer> numbers = Arrays.asList(9, 5, 19, 64, 37, 85, 14, 19);

        // 1. Создание стрима из коллекции
        Stream<Integer> streamFromCollection = numbers.stream();

        // 2. Создание стрима из значений
        Stream<Integer> streamFromValues = Stream.of(9, 5, 19, 64, 37, 85, 14, 19);

        // 3. Создание стрима из массива
        Integer[] array = {9, 5, 19, 64, 37, 85, 14, 19};
        Stream<Integer> streamFromArrays = Arrays.stream(array);

        // 4. Создание стрима из файла
        Stream<String> streamFromFiles = Files.lines(Paths.get("src/stream/input.txt"));

        // 5. Создание стрима из строки
        IntStream streamFromString = "Hello World!".chars();

        // 6. С помощью Stream.builder
        Stream.builder().add(9).add(5).add(19).add(64).add(37).add(85).add(14).add(19).build();

        // 7. Создание параллельного стрима
        Stream<Integer> parallelStream = numbers.parallelStream();

        // 8. Создание бесконечных стрима с помощью Stream.iterate
        Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n + 1);

        // 9. Создание бесконечных стрима с помощью Stream.generate
        Stream<Integer> streamFromGenerate = Stream.generate(() -> new Random().nextInt(1000));

        // Конвейерные методы
        System.out.println("filter");
        filterTest();

        System.out.println("skip");
        skipTest();

        System.out.println("distinct");
        distinctTest();

        System.out.println("map");
        mapTest();

        System.out.println("peek");
        peekTest();

        System.out.println("limit");
        limitTest();

        System.out.println("sorted");
        sortedTest();

        System.out.println("mapToInt");
        mapToIntTest();

        System.out.println("flatMap");
        flatMapTest();

        System.out.println("flatMap2");
        flatMap2Test();

        // Терминальные методы
        System.out.println("findFirst");
        findFirstTest();

        System.out.println("findAny");
        findAnyTest();

        System.out.println("collect");
        collectTest();

        System.out.println("count");
        countTest();

        System.out.println("match");
        anyMatchTest();

        System.out.println("noneMatch");
        noneMatchTest();

        System.out.println("allMatch");
        allMatchTest();

        System.out.println("min");
        minTest();

        System.out.println("max");
        maxTest();

        System.out.println("forEach");
        forEachTest();

        System.out.println("forEachOrdered");
        forEachOrderedTest();

        System.out.println("toArray");
        toArrayTest();

        System.out.println("reduce");
        reduceTest();
    }

    private static void filterTest() {
        Stream.of(3, 10, 16, 20).filter(n -> n % 10 == 0).forEach(System.out::println);
    }

    private static void skipTest() {
        Stream.of(3, 10, 16, 20).skip(2).forEach(System.out::println);
    }

    private static void distinctTest() {
        Stream.of(3, 10, 3).distinct().forEach(System.out::println);
    }

    private static void mapTest() {
        Stream.of(3, 10, 16, 20).map(n -> n + 1).forEach(System.out::println);
    }

    private static void peekTest() {
        long count = Stream.of(3, 10, 16, 20).peek(System.out::println).count();
    }

    private static void limitTest() {
        Stream.of(3, 10, 16, 20).limit(2).forEach(System.out::println);
    }

    private static void sortedTest() {
        Stream.of(10, 16, 20, 3).sorted().forEach(System.out::println);
    }

    private static void mapToIntTest() {
        Stream.of("3", "10", "16", "20").mapToInt(Integer::valueOf).forEach(System.out::println);
    }

    private static void flatMapTest() {
        Stream.of("3,10", "16,20").flatMap(n -> Arrays.stream(n.split(","))).forEach(System.out::println);
    }

    private static void flatMap2Test() {
        Stream.of(3, 10, 16, 20).flatMap(n -> Stream.of(n + 1, n - 1)).forEach(System.out::println);
    }

    private static void findFirstTest() {
        int first = Stream.of(3, 10, 16, 20).findFirst().orElse(0);
        System.out.println(first);
    }

    private static void findAnyTest() {
        int any = Stream.of(3, 10, 16, 20).findAny().orElse(0);
        System.out.println(any);
    }

    private static void collectTest() {
        List<Integer> list = Stream.of(3, 10, 16, 20).limit(2).collect(Collectors.toList());
        System.out.println(list);
    }

    private static void countTest() {
        long count = Stream.of(3, 10, 16, 20).count();
        System.out.println(count);
    }

    private static void anyMatchTest() {
        boolean match = Stream.of(3, 10, 16, 20).anyMatch(n -> n > 18);
        System.out.println(match);
    }

    private static void noneMatchTest() {
        boolean match = Stream.of(3, 10, 16, 20).noneMatch(n -> n == 50);
        System.out.println(match);
    }

    private static void allMatchTest() {
        boolean match = Stream.of(3, 10, 16, 20).allMatch(n -> n > 0);
        System.out.println(match);
    }

    private static void minTest() {
        int min = Stream.of(3, 10, 16, 20).min(Integer::compareTo).get();
        System.out.println(min);
    }

    private static void maxTest() {
        int max = Stream.of(3, 10, 16, 20).max(Integer::compareTo).get();
        System.out.println(max);
    }

    private static void forEachTest() {
        Stream.of(3, 10, 16, 20).forEach(System.out::println);
    }

    private static void forEachOrderedTest() {
        Stream.of(3, 10, 16, 20).parallel().forEachOrdered(System.out::println);
    }

    private static void toArrayTest() {
        Integer[] array = Stream.of(3, 10, 16, 20).toArray(Integer[]::new);
        System.out.println(array.length);
    }

    private static void reduceTest() {
        long multi = Stream.of(3, 10, 16, 20).reduce((n1, n2) -> n1 * n2).get();
        System.out.println(multi);
    }
}
