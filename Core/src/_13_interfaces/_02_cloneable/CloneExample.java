package _13_interfaces._02_cloneable;

public class CloneExample {

	@Override
	public Object clone() {
		return new CloneExample();
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		CloneExample cloneExample = new CloneExample();
		CloneExample clone = (CloneExample) cloneExample.clone();
		System.out.println("clone origin = " + cloneExample);
		System.out.println("clone		 = " + clone);
	}
}