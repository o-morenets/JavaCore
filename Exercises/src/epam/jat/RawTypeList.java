package epam.jat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RawTypeList {

	public static void main(String []args) {
		List<String> list = Arrays.asList("A", "B");
		List<Integer> data = new ArrayList(list);
		Integer intNumber = data.get(0);
		System.out.println(data);
	}
}
