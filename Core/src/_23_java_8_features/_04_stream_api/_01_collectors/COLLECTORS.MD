# Collectors

### Standard
* toCollection
    * public static <T, C extends Collection<T>> Collector<T, ?, C> `toCollection`(Supplier<C> collectionFactory)
* toConcurrentMap
    * public static <T, K, U> Collector<T, ?, ConcurrentMap<K,U>> `toConcurrentMap`(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper)
    * public static <T, K, U> Collector<T, ?, ConcurrentMap<K,U>> `toConcurrentMap`(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper, BinaryOperator< U > mergeFunction)
    * public static <T, K, U, M extends ConcurrentMap<K, U>> Collector<T, ?, M> `toConcurrentMap`(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper, BinaryOperator< U > mergeFunction, Supplier<M> mapFactory)
* toList
    * public static <T> Collector<T, ?, List<T>> `toList`()
* toMap
    * public static <T, K, U> Collector<T, ?, Map<K,U>> `toMap`(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper)
    * public static <T, K, U> Collector<T, ?, Map<K,U>> `toMap`(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper, BinaryOperator< U > mergeFunction)
    * public static <T, K, U, M extends Map<K, U>> Collector<T, ?, M> `toMap`(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper, BinaryOperator< U > mergeFunction, Supplier<M> mapFactory)
* toSet
    * public static <T> Collector<T, ?, Set<T>> `toSet`()
* toUnmodifiableList
    * public static <T> Collector<T, ?, List<T>> `toUnmodifiableList`()
* toUnmodifiableMap
    * public static <T, K, U> Collector<T, ?, Map<K,U>> `toUnmodifiableMap`(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper)
    * public static <T, K, U> Collector<T, ?, Map<K,U>> `toUnmodifiableMap`(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends U> valueMapper, BinaryOperator< U > mergeFunction)
* toUnmodifiableSet
    * public static <T> Collector<T, ?, Set<T>> `toUnmodifiableSet`()

### -ing
* collectingAndThen
  * public static<T,A,R,RR> Collector<T,A,RR> `collectingAndThen`(Collector<T,A,R> downstream, Function<R,RR> finisher)
* counting
  * public static <T> Collector<T, ?, Long> `counting()`
* filtering
  * public static <T, A, R> Collector<T, ?, R> `filtering`(Predicate<? super T> predicate, Collector<? super T, A, R> downstream)
* flatMapping
  * public static <T, U, A, R> Collector<T, ?, R> `flatMapping`(Function<? super T, ? extends Stream<? extends U>> mapper, Collector<? super U, A, R> downstream)
* groupingBy
  * public static <T, K> Collector<T, ?, Map<K, List<T>>> `groupingBy`(Function<? super T, ? extends K> classifier)
  * public static <T, K, A, D> Collector<T, ?, Map<K, D>> `groupingBy`(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream)
  * public static <T, K, D, A, M extends Map<K, D>> Collector<T, ?, M> `groupingBy`(Function<? super T, ? extends K> classifier, Supplier<M> mapFactory, Collector<? super T, A, D> downstream)
* groupingByConcurrent
  * public static <T, K> Collector<T, ?, ConcurrentMap<K, List<T>>> `groupingByConcurrent`(Function<? super T, ? extends K> classifier)
  * public static <T, K, A, D> Collector<T, ?, ConcurrentMap<K, D>> `groupingByConcurrent`(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream)
  * public static <T, K, A, D, M extends ConcurrentMap<K, D>> Collector<T, ?, M> `groupingByConcurrent`(Function<? super T, ? extends K> classifier, Supplier<M> mapFactory, Collector<? super T, A, D> downstream)
* joining
  * public static Collector<CharSequence, ?, String> `joining`()
  * public static Collector<CharSequence, ?, String> `joining`(CharSequence delimiter)
  * public static Collector<CharSequence, ?, String> `joining`(CharSequence delimiter, CharSequence prefix, CharSequence suffix)
* mapping
  * public static <T, U, A, R> Collector<T, ?, R> `mapping`(Function<? super T, ? extends U> mapper, Collector<? super U, A, R> downstream)
* max/min
  * public static <T> Collector<T, ?, Optional<T>> `maxBy`(Comparator<? super T> comparator)
  * public static <T> Collector<T, ?, Optional<T>> `minBy`(Comparator<? super T> comparator)
* partitioning
  * public static <T> Collector<T, ?, Map<Boolean, List<T>>> `partitioningBy`(Predicate<? super T> predicate)
  * public static <T, D, A> Collector<T, ?, Map<Boolean, D>> `partitioningBy`(Predicate<? super T> predicate, Collector<? super T, A, D> downstream)
* reducing
  * public static <T> Collector<T, ?, Optional<T>> `reducing`(BinaryOperator<T> op)
  * public static <T> Collector<T, ?, T> `reducing`(T identity, BinaryOperator<T> op)
  * public static <T, U> Collector<T, ?, U> `reducing`(U identity, Function<? super T, ? extends U> mapper, BinaryOperator< U > op)
* teeing
  * public static <T, R1, R2, R> Collector<T, ?, R> `teeing`(Collector<? super T, ?, R1> downstream1, Collector<? super T, ?, R2> downstream2, BiFunction<? super R1, ? super R2, R> merger)

#### Aggregation
* averaging
  * public static <T> Collector<T, ?, Double> `averagingDouble`(ToDoubleFunction<? super T> mapper)
  * public static <T> Collector<T, ?, Double> `averagingInt`(ToIntFunction<? super T> mapper)
  * public static <T> Collector<T, ?, Double> `averagingLong`(ToLongFunction<? super T> mapper)
* summarizing
  * public static <T> Collector<T, ?, DoubleSummaryStatistics> `summarizingDouble`(ToDoubleFunction<? super T> mapper)
  * public static <T> Collector<T, ?, IntSummaryStatistics> `summarizingInt`(ToIntFunction<? super T> mapper)
  * public static <T> Collector<T, ?, LongSummaryStatistics> `summarizingLong`(ToLongFunction<? super T> mapper)
* summing
  * public static <T> Collector<T, ?, Double> `summingDouble`(ToDoubleFunction<? super T> mapper)
  * public static <T> Collector<T, ?, Integer> `summingInt`(ToIntFunction<? super T> mapper)
  * public static <T> Collector<T, ?, Long> `summingLong`(ToLongFunction<? super T> mapper)