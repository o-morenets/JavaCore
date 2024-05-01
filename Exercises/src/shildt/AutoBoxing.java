package shildt;

public class AutoBoxing {

	static void changeValue(Integer i) {
		i = Integer.valueOf(5);
	}
	
	public static void main(String[] args) {
		Integer value = 3;
		changeValue(value);
		System.out.println(value); // still 3
	}
	
}
