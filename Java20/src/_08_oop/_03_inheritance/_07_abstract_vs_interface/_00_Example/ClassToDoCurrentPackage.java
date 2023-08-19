package _08_oop._03_inheritance._07_abstract_vs_interface._00_Example;

public class ClassToDoCurrentPackage extends Child {
    @Override
    protected String doNothing() {
        System.out.println("overridden here");
        return super.doNothing();
    }

    public static void main(String[] args) {
        ClassToDoCurrentPackage classTODO = new ClassToDoCurrentPackage();

        Child child = new Child();
        child.doSomething();
        child.todo();

        classTODO.doNothing();
    }
}
