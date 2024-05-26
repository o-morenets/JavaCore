package _01_datastructures.heap;

import java.util.*;

public class MaxHeap<T extends Comparable<T>> {

    private final Object[] array;
    private int size;

    public MaxHeap(int size) {
        this.array = new Object[size];
        this.size = 0;
    }

    public MaxHeap(Collection<T> collection) {
        this.size = collection.size();
        this.array = buildMaxHeap(collection);
    }

    public static <T extends Comparable<T>> MaxHeap<T> of(T... elements) {
        return new MaxHeap<>(Arrays.asList(elements));
    }

    public static <T extends Comparable<T>> Collection<T> heapSort(Collection<T> collection) {
        MaxHeap<T> maxHeap = new MaxHeap<>(collection);
        List<T> result = new ArrayList<>(); // addFirst to ArrayList is very slow!!!
        while (!maxHeap.isEmpty()) {
            result.addFirst(maxHeap.poll());
        }
        return result;
    }

    public Collection<T> sorted() {
        List<T> result = new LinkedList<>();
        while (!isEmpty()) {
            result.addFirst(poll());
        }
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T element) {
        if (array.length == size) {
            throw new IllegalArgumentException("Heap is full!");
        }

        array[size] = element;
        siftUp(array, size);
        size++;
    }

    public T poll() {
        T e = (T) array[0];
        array[0] = array[size - 1];
        array[size - 1] = e;
        size--;
        siftDown(array, 0);
        return e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // TODO tree output
        return Arrays.toString(array);
    }

    private Object[] buildMaxHeap(Collection<T> collection) {
        Object[] array = collection.toArray();
        heapify(array);
        return array;
    }

    private void heapify(Object[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            siftDown(array, i);
        }
    }

    private void siftDown(Object[] array, int i) {
        while (i < size / 2) {
            int maxIndex = i;
            T max = (T) array[i];
            int right = 2 * i + 2;
            if (right < size && max.compareTo((T) array[right]) < 0) {
                maxIndex = right;
                max = (T) array[right];
            }
            int left = 2 * i + 1;
            if (left < size && max.compareTo((T) array[left]) < 0) {
                maxIndex = left;
                max = (T) array[left];
            }
            if (maxIndex != i) {
                array[maxIndex] = array[i];
                array[i] = max;
                i = maxIndex;
            } else {
                break;
            }
        }
    }

    private void siftUp(Object[] array, int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (((T) array[i]).compareTo((T) array[parent]) > 0) {
                Object temp = array[i];
                array[i] = array[parent];
                array[parent] = temp;
            }
            i = parent;
        }
    }
}
