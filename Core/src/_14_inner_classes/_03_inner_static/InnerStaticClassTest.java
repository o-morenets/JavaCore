package _14_inner_classes._03_inner_static;

public class InnerStaticClassTest {

	public static void main(String[] args) {
		double[] d = new double[20];

		for (int i = 0; i < d.length; i++)
			d[i] = 100 * Math.random();

		ArrayAlg.Pair p = ArrayAlg.minmax(d);
		System.out.println("min = " + p.getFirst());
		System.out.println("max = " + p.getSecond());
	}
}

class ArrayAlg {

	public static class Pair {

		private double first;
		private double second;

		public Pair(double first, double second) {
			this.first = first;
			this.second = second;
		}

		public double getFirst() {
			return first;
		}

		public double getSecond() {
			return second;
		}
	}

	public static Pair minmax(double[] values) {
		double min = Double.POSITIVE_INFINITY;
		double max = Double.NEGATIVE_INFINITY;

		for (double v : values) {
			if (min > v)
				min = v;
			if (max < v)
				max = v;
		}
		return new Pair(min, max);
	}
}