package stackOverflow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AnotherClass {
    static AnotherClass a = new AnotherClass(); //здесь мы создаем статическую переменную, иначе компилятор будет ругаться

    public static void main(String[] args) {

        AnotherClass b = new AnotherClass(); //здесь использование static не обязательно, так как переменная создается внутри метода

        a.readFile();
        b.readFile(); // оба варианта возможны
    }

    public void readFile() {
        try {
            File file = new File("sdsd");
            Scanner scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
        }
    } // если не использовать конструкцию try{} catch{}, то компилятор будет ругаться на неотловленное исключение. Ключевое слово throws же говорит о том, что внутри метода вручную бросается какое-то исключение с помощью throw, что у вас не происходит.
}