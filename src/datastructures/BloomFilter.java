package datastructures;

public class BloomFilter<T> {

    private boolean[] filter;

    private int m;

    BloomFilter(int m) {
        this.m = m;
        filter = new boolean[m];
    }

    public static void main(String[] args) {
        BloomFilter<String> bloomFilter = new BloomFilter<>(64);
        bloomFilter.put("Hello!");
        bloomFilter.put("Wold!");
        System.out.println(bloomFilter.check("Hello!"));
        System.out.println(bloomFilter.check("Wold!"));
        System.out.println(bloomFilter.check("123"));
    }

    public void put(T value) {
        filter[hash(value)] = true;
    }

    public boolean check(T value) {
        return filter[hash(value)];
    }

    private int hash(T value) {
        return Math.abs(value.hashCode() % m);
    }
}
