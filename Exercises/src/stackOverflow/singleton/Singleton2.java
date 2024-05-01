package stackOverflow.singleton;

public class Singleton2 {
    static Singleton2 st = new Singleton2();

    Singleton2(){
        System.out.println("Инициализация ");
    }

    public static void main(String[] args) {

    }
}