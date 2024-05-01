package stackOverflow.linkedListImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListOwnImplTest {
    LinkedListOwn<String> linkedListOwn;

    @Before
    public void setUp() {
        linkedListOwn = new LinkedListOwnImpl<>();
        linkedListOwn.addLast("A");
    }

    @Test
    public void addFirst() {
        LinkedListOwn<String> expected = new LinkedListOwnImpl<>();
        expected.addLast("B");
        expected.addLast("A");

        linkedListOwn.addFirst("B");

        Assert.assertEquals(expected, linkedListOwn);
    }
}
