package stackOverflow.reversLinkedList;

public class Node {
    private int value;
    private Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }

    public Node revers(){
        Node before = null;
        Node n = this;
        Node after = n.next;
        while(n != null){
            n.next = before;
            before = n;
            n = after;
            if (n != null)
                after = n.next;
        }
        return before;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static void main(String[] args) {
        Node node = new Node(60, null);
        node = new Node(50, node);
        node = new Node(40, node);
        node = new Node(30, node);
        node = new Node(20, node);
        node = new Node(10, node);

        System.out.println(node);
        node = node.revers();
        System.out.println(node);
    }
}
