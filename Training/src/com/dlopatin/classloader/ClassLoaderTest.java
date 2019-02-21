package com.dlopatin.classloader;

public class ClassLoaderTest {

    public static void main(String[] args) {
        System.out.println(C.b);
    }

}

class A {
    static {
        System.out.println("A");
    }
}

class B extends A {
    static int b = 1;

    static {
        System.out.println("B");
    }
}

class C extends B {
    static int c = 2;

    static {
        b++;
        System.out.println("C");
        System.exit(0);
    }
}
