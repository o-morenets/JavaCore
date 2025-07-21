package _23_java_8_features._00_functional_interfaces.functions_java8;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BooleanSupplier;

public class BooleanSupplierDemo {

    public static void main(String[] args) {

        // () -> boolean
        BooleanSupplier healthChecker = () -> {;
            return ThreadLocalRandom.current().nextBoolean();
        };

        if (healthChecker.getAsBoolean()) {
            System.out.println("The system is healthy.");
        } else {
            System.out.println("The system is unhealthy.");
        }
    }

}
