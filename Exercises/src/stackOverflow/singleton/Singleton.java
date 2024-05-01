package stackOverflow.singleton;

public class Singleton {
    static Singleton st = new Singleton();

    static { //статический блок
        System.out.println("Статический блок");
    }

    { //анонимный блок
        System.out.println("Динамический блок");
    }

    Singleton(){ //конструктор
        System.out.println("Конструктор");

    }
    public static void main(String[] args) {
        //Пустая точка входа
    }
}