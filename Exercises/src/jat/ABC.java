package jat;

public class ABC {
    public static void main(String[] args) {
        A ab = new B();
//        A ac = new C();
//        C cb = (C) new B();
    }
}

class A {
    public A() {
        System.out.println("A");
    }

/*
    public A(int a) {
        System.out.println("A" + a);
    }
*/
}

class B extends A {
    public B() {
//        super();
        System.out.println("B");
    }

    public B(int b) {
        super();
        System.out.println("B" + b);
    }
}

/*
class C extends B {

}
*/
