package reflector;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Reflector {
	public static void main(String[] args) throws Exception {
		Set<String> s = new HashSet<String>();
		s.add("foo");
		Iterator it = s.iterator();
//		Method m = it.getClass().getMethod("hasNext");-

		// Fix:
		Method m = Iterator.class.getMethod("hasNext");
		System.out.println(m.invoke(it));
	}
}

// Exception in thread "main" java.lang.IllegalAccessException:
// class reflector.Reflector cannot access a member of class java.util.HashMap$HashIterator (in module java.base) with modifiers "public final"