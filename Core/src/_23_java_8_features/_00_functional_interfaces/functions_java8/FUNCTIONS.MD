# Function - R apply(T)
## Function
### T -> R
    Function (T -> R)
### primitive -> primitive
    DoubleToIntFunction  (double -> int)
    DoubleToLongFunction (double -> long)
    IntToDoubleFunction  (int -> double)
    IntToLongFunction    (int -> long)
    LongToDoubleFunction (long -> double)
    LongToIntFunction    (long -> int)
### primitive -> T
    DoubleFunction (double -> R)
    IntFunction    (int -> R)
    LongFunction   (long -> R)
### T -> primitive
    ToDoubleFunction (T -> double)
    ToIntFunction (T -> int)
    ToLongFunction (T -> long)
### UnaryOperator
    UnaryOperator extends Function<T,T> (T -> T)

    DoubleUnaryOperator (double -> double)
    IntUnaryOperator    (int -> int)
    LongUnaryOperator   (long -> long)

## Binary Function
### T,U -> R
    BiFunction (T,U -> R)
### T,U -> primitive
    ToDoubleBiFunction (T,U -> double)
    ToIntBiFunction    (T,U -> int)
    ToLongBiFunction   (T,U long)
### BinaryOperator
    BinaryOperator extends Function<T,T,T> (T,T -> T)

    DoubleBinaryOperator (double, double -> double)
    IntBinaryOperator    (int, int -> int)
    LongBinaryOperator   (long, long -> long)

# Predicate - boolean test(T)
    Predicate (T -> boolean)

    DoublePredicate (double -> boolean)
    IntPredicate    (int -> boolean)
    LongPredicate   (long -> boolean)

    BiPredicate (T,U -> boolean)

# Consumer - void accept(T)
    Consumer (T -> void)

    DoubleConsumer (double -> void)
    IntConsumer    (int -> void)
    LongConsumer   (long -> void)

    ObjDoubleConsumer (T,double -> void)
    ObjIntConsumer    (T,int -> void)
    ObjLongConsumer   (T,long -> void)

    BiConsumer (T,U -> void)

# Supplier - T get()
    Supplier (()-> T)

    BooleanSupplier (-> boolean)
    DoubleSupplier  (-> double)
    IntSupplier     (-> int)
    LongSupplier    (-> long)