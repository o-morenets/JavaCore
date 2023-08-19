package _08_oop._00_classes.classLoader;

public class NoClassDefFoundErrorExample {

    public static void main(String[] args) {
        ClassWithInitErrors sample = new ClassWithInitErrors();
        sample.getClassWithInitErrors();
    }
}
class ClassWithInitErrors {
    static int data = 1 / 0;

    public ClassWithInitErrors getClassWithInitErrors() {
        ClassWithInitErrors test;
        try {
            test = new ClassWithInitErrors();
        } catch (Throwable t) {
            System.out.println(t);
        }
        test = new ClassWithInitErrors();
        return test;
    }

}
