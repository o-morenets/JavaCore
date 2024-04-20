package _18_java_8_features._04_stream_api._01_collectors;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.LongStream;

public class CustomCollectorDemo {

    /**
     * Collector for Unmodifiable LinkedList of Long numbers
     */
    private static class CustomCollector implements Collector<Long, List<Long>, List<Long>> {

        @Override
        public Supplier<List<Long>> supplier() {
            return LinkedList::new;
        }

        @Override
        public BiConsumer<List<Long>, Long> accumulator() {
            return List::add;
        }

        @Override
        public BinaryOperator<List<Long>> combiner() {
            return (list1, list2) -> {
                list1.addAll(list2);
                return list1;
            };
        }

        @Override
        public Function<List<Long>, List<Long>> finisher() {
            return Collections::unmodifiableList;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Set.of(Characteristics.UNORDERED);
        }

    }

    public static void main(String[] args) {

        List<Long> list = LongStream.range(0, 10)
                .boxed()
                .collect(new CustomCollector());
        System.out.println(list);
        list.set(3, 43L); // UnsupportedOperationException - can not modify Unmodifiable List
    }

}
