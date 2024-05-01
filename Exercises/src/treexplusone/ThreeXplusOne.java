package treexplusone;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreeXplusOne {

    private Map<Integer, Solution> solutionMap;

    public static void main(String[] args) {
        ThreeXplusOne threeXplusOne = new ThreeXplusOne();
        threeXplusOne.initNumbers(0, 10_0);
        threeXplusOne.printStatistics();
    }

    private void initNumbers(int numberFrom, int numberTo) {
        solutionMap = IntStream.rangeClosed(numberFrom, numberTo).boxed().collect(Collectors.toMap(Function.identity(), Solution::new));
    }

    private void printStatistics() {
//        solutionMap.forEach((num, solution) -> System.out.println(solution));

        Solution solutionMaxSteps = solutionMap.values().stream().max(Comparator.comparing(Solution::getSteps)).orElseGet(() -> new Solution(-1));
        Solution solutionMaxNumber = solutionMap.values().stream().max(Comparator.comparing(Solution::getMaxNumber)).orElseGet(() -> new Solution(-1));

        System.out.println("solutionMaxSteps = " + solutionMaxSteps);
        System.out.println("solutionMaxNumber = " + solutionMaxNumber);
    }

    private static class Solution {
        private int number;
        private int steps;
        private int maxNumber;

        public int getNumber() {
            return number;
        }

        public int getSteps() {
            return steps;
        }

        public int getMaxNumber() {
            return maxNumber;
        }

        public Solution(int number) {
            this.number = number;
            solution();
        }

        private void solution() {
            int x = number;
            System.out.print(x + ": ");
            while (x > 1) {
                steps++;
                if ((x & 1) == 0) {
                    x /= 2;
                } else {
                    x = x * 3 + 1;
                }
//                System.out.print(x + " ");
                if (x > maxNumber) {
                    maxNumber = x;
                }
            }
            System.out.println(" (" + steps + ")");
        }

        @Override
        public String toString() {
            return "Solution{" +
                    "number=" + number +
                    ", steps=" + steps +
                    ", maxNumber=" + maxNumber +
                    '}';
        }
    }
}
