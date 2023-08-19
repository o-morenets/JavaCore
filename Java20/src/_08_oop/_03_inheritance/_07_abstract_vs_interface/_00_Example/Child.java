package _08_oop._03_inheritance._07_abstract_vs_interface._00_Example;

public class Child extends ClassA {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    protected String doNothing() {
        return "Do Nothing";
    }

    @Override
    void todo() {
        System.out.println("todo");
    }
}
