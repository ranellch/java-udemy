package com.ranella;

public class Main {

    public static void main(String[] args) {
        A a = output();
        if (a instanceof B) {
            System.out.println("B");
        }




    }

    public static A output() {
        return new B();
    }

    static class A {
        int x = 1;

        public A() {
        }

        public void test() {
            System.out.println("Class A");
         };
    }

    static class B extends A {
        int y = 2;

        @Override
        public void test() {
            System.out.println("Class B");
        }
    }
}
