package stackOverflow.linkedListImpl;

import java.util.Objects;

public class LinkedListOwnImpl<T> implements LinkedListOwn<T> {
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;

    public LinkedListOwnImpl() {
        lastNode = new Node<>(null, firstNode, null);
        firstNode = new Node<>(null, null, lastNode);
    }

    @Override
    public void addFirst(T element) {
        Node<T> newNext = firstNode;
        newNext.value = element;
        firstNode = new Node<>(null, null, newNext);
        newNext.prev = firstNode;
        while (getNextNode(newNext) != lastNode) {
            newNext = getNextNode(newNext);
        }
        lastNode.prev = newNext;
        size++;
    }

    private Node<T> getNextNode(Node<T> next) {
        // TODO
        return next;
    }

    @Override
    public void addLast(T element) {
        // TODO
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedListOwnImpl)) return false;
        LinkedListOwnImpl<?> that = (LinkedListOwnImpl<?>) o;
        return size == that.size &&
                Objects.equals(firstNode, that.firstNode) &&
                Objects.equals(lastNode, that.lastNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNode, lastNode, size);
    }

    @Override
    public String toString() {
        String str = "";
        Node<T> node = firstNode;
        while (getNextNode(node) != lastNode) {
            str += getNextNode(node).value.toString() + "; ";
            node = getNextNode(node);
        }
        return str;
    }

    private static class Node<T> {
        private T value;
        private Node<T> prev;
        private Node<T> next;

        Node(T value, Node<T> prev, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(value, node.value) &&
                    Objects.equals(prev, node.prev) &&
                    Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, prev, next);
        }
    }
}
