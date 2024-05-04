package _20_multithreading._12_volatile.doublecheck;

public class DoubleCheckProblem {

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
    }

    private static class Singleton {

        private static volatile Singleton instance;

        private Singleton() {}

        public static Singleton getInstance() {
            if (instance == null) { // Intellij IDEA knows about double locking and suggests volatile
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton(); // reordering is possible here, so we need volatile variable
                    }
                }
            }
            return instance;
        }
    }
}
