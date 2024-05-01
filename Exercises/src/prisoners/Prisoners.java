package prisoners;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class Prisoners {

    public static final int NUM_PRISONERS = 100;
    public static final int NUM_RUNS = 100_000_000;

    public static void main(String[] args) {
        new Prisoners().runApplication();
    }

    private void runApplication() {
        double loses = 0d;
        double winners = 0d;
        List<List<Integer>> cycles;
        for (int i = 0; i < NUM_RUNS; i++) {
            int[] boxes = ThreadLocalRandom.current().ints(1, NUM_PRISONERS + 1).distinct().limit(NUM_PRISONERS).toArray();
            cycles = findAllCycles(boxes);
            Optional<List<Integer>> maxCycleOpt = cycles.stream().max(Comparator.comparing(List::size));
            if (maxCycleOpt.isPresent()) {
                List<Integer> maxCycle = maxCycleOpt.get();
                if (maxCycle.size() > NUM_PRISONERS / 2) {
                    loses++;
                } else {
                    winners++;
                }
            }

            if (i % 1000 == 0) {
                System.out.print(".");
            }

            if (i % 100_000 == 0) {
                System.out.println();
                System.out.println("-------------- step " + i + " --------------");
                System.out.println("loses = " + loses / i * 100);
                System.out.println("winners = " + winners / i * 100);

                System.out.println(">> Cycles (" + cycles.size() + "):");
                printCycles(cycles);
            }
        }
    }

    private static void printCycles(List<List<Integer>> cycles) {
        cycles.forEach(cycle -> System.out.println(cycle.size() + ": " + cycle));
        System.out.println("All Cycles Count (just check) = " + cycles.stream().mapToLong(List::size).sum());
    }

    private List<List<Integer>> findAllCycles(int[] boxes) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        for (int i : boxes) {
            if (result.stream().flatMap(List::stream).noneMatch(number -> number == i)) {
                result.add(findCycle(boxes, i));
            }
        }
        return result;
    }

    private List<Integer> findCycle(int[] boxes, int i) {
        List<Integer> result = new ArrayList<>();

        int temp = boxes[i - 1];
        result.add(temp);

        while (temp != i) {
            temp = boxes[temp - 1];
            result.add(temp);
        }

        return result;
    }
}
