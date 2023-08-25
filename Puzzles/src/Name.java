import java.util.HashSet;
import java.util.Set;

/**
 * Adding object to HashSet with overridden equals() without hashCode()
 */
public class Name {
	private final String first, last;

	public Name(String first, String last) {
		this.first = first;
		this.last = last;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Name))
			return false;
		Name n = (Name) o;
		return n.first.equals(first) && n.last.equals(last);
	}

	public static void main(String[] args) {
		Set<Name> s = new HashSet<Name>();
		s.add(new Name("Mickey", "Mouse"));
		System.out.println(s.contains(new Name("Mickey", "Mouse"))); // false
		// Even the objects were stored in same bucket, their hash is also stored and will be checked first
		// Only if hashes are equal, objects will be checked for equality
	}

	// Fix: implement proper hashCode():
/*
	@Override
	public int hashCode() {
		return 37 * first.hashCode() + last.hashCode();
	}
*/
}