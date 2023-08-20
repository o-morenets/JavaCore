package _13_interfaces._03_cloneable;

public class CloneExample {

	@Override
	public Object clone() throws CloneNotSupportedException {
		return new CloneExample();
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		CloneExample cloneExample = new CloneExample();
		CloneExample clone = (CloneExample) cloneExample.clone();
		System.out.println(clone);
	}
}