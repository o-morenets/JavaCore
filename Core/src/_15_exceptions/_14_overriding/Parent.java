package _15_exceptions._14_overriding;

import java.io.FileNotFoundException;
import java.io.IOException;

// When overriding, the list of exceptions thrown by the child method does not have to match that of the parent.
// But it must be "not stronger" than the parent's list:

public class Parent {

	// The parent declares IOException and InterruptedException
	public void f() throws IOException, InterruptedException {
	}
}

class Child extends Parent {

	// The child declares only a subclass of IOException
	@Override
	public void f() throws FileNotFoundException {
	}
}

class ChildB extends Parent {

//    @Override
//    public void f() throws Exception {}

	// >> COMPILATION ERROR: overridden method does not throw 'java.lang.Exception'
}
