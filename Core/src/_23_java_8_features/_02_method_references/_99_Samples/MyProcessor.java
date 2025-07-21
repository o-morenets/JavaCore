package _23_java_8_features._02_method_references._99_Samples;

import java.util.function.IntFunction;
import java.util.function.Supplier;

public class MyProcessor {

    int value;

    public MyProcessor() {
        this.value = 10;
    }

    public MyProcessor(int value) {
        this.value = value;
    }

    public void process() {
        System.out.println("Processing value: " + value);
    }

    public static void main(String[] args) {
        Supplier<MyProcessor> supp = MyProcessor::new; // calls Constructor reference with no arguments
        MyProcessor mp = supp.get();
        mp.process();

        IntFunction<MyProcessor> f = MyProcessor::new; // calls Constructor reference with one argument
        MyProcessor mp2 = f.apply(10);
        mp2.process();
    }
}
