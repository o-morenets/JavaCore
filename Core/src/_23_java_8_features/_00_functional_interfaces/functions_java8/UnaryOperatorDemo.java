package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {
    public static void main(String[] args) {

        // T -> T
        UnaryOperator<Integer> multiplyByTwo = x -> x * 2;

        int input = 5;
        int result = multiplyByTwo.apply(input);

        System.out.println("Input: " + input);
        System.out.println("Result after applying UnaryOperator: " + result);
    }
}
