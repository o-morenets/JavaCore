package _18_stream_api._00_lambda_vs_method_reference;

import java.util.function.Function;
import java.util.stream.Stream;

public class LambdaVsMethodReference {

    /**
     * If you do not follow the rules of clean functional programming,
     * there may be a change of semantics when you convert a lambda to a method reference.
     * The difference is that the method reference will be resolved only once when the stream is being built.
     * But in the lambda expression the code for getting the method can be evaluated in each execution of the lambda.
     * Here is a short self-contained example for demonstration:
     *
     * <a href="https://stackoverflow.com/questions/61283367/intellij-method-reference-may-change-semantics"></a>
     *
     * @param args
     */
    public static void main(String[] args) {

        Function<Integer, Integer> f2 = n -> 2 * n;
        Function<Integer, Integer> f3 = n -> 3 * n;
        Function<Integer, Integer>[] funcArray = new Function[1];

        funcArray[0] = f2;
        Stream.of(1, 2, 3)
                .peek(n -> {
                    if (n > 1) funcArray[0] = f3;
                })
                .map(funcArray[0]::apply)            // Method reference, '::apply' could be omitted
                .forEach(System.out::print);         // prints 246
        System.out.println();

        funcArray[0] = f2;
        Stream.of(1, 2, 3)
                .peek(n -> {
                    if (n > 1) funcArray[0] = f3;
                })
                .map(n -> funcArray[0].apply(n))     // Lambda
                .forEach(System.out::print);         // prints 269
        System.out.println();
    }
}
