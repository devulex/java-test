package oop;

public class Main {

    public static void main(String... args) {
        new B();
    }
}

class A {
    public A() {
        System.out.println("init A");
        print();
    }

    public A(String s) {
        System.out.println(s);
    }

    void print() {
        System.out.println("print A");
    }
}

class B extends A {
    B() {
        //super("1");
        //System.out.println("init B");
        //print();
    }

    @Override
    void print() {
        System.out.println("print B");
    }
}
