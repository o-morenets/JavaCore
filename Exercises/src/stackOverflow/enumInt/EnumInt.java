package stackOverflow.enumInt;

public class EnumInt {

    enum Rating {
        ONE(1), THREE(3), NINE(9);

        private final int value;

        Rating(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        System.out.println(Rating.THREE.getValue() < Rating.NINE.getValue());
    }
}
