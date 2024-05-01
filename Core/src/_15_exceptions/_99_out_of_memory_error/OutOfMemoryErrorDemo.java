package _15_exceptions._99_out_of_memory_error;

public class OutOfMemoryErrorDemo {

    private static final int SIZE = 1024 * 1024;

    public static void main(String[] args) {
        runIntoOOM();
    }

    private static void runIntoOOM() {
        Object[] tail = null;
        int i = 0;
        Runtime rt = Runtime.getRuntime();
        while (true) {
            System.out.printf("[%4d] Available heap memory: %s%n", i++, rt.freeMemory());
            tail = new Object[]{tail, new Object[SIZE]};
        }
    }
}
