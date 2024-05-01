package stackOverflow.generics;

import java.util.ArrayList;
import java.util.List;

public class ExtendsNumber {

    public static Double sum(List<? extends Number> numList) {
        return numList.stream()
                .mapToDouble(Number::doubleValue)
                .reduce((left, right) -> left + right)
                .orElseGet(() -> 0.0);
    }

    public static void main(String[] args) {
        List<Double> numList = new ArrayList<>();

        Double sum = sum(numList);
        System.out.println("sum = " + sum);
    }

}
