package stackOverflow.generics.mathOps;

public class VectorX2<Type extends Number> {
    private Type x;
    private Type y;

    public VectorX2(Type x, Type y) {
        this.x = x;
        this.y = y;
    }

    public void add(VectorX2<? extends Number> another) {
        Number n = x.doubleValue() + another.x.doubleValue();
        x = (Type) n;
    }

    @Override
    public String toString() {
        return "VectorX2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        VectorX2<Integer> v = new VectorX2<>(1, 2);
        System.out.println("v = " + v);

        v.add(new VectorX2<>(3, 4));
        System.out.println("v = " + v);
    }
}
