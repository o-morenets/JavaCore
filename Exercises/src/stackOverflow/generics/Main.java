package stackOverflow.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static <T extends List<Integer>> T newList() {
        return (T) new ArrayList<Integer>();
    }

    public static void main(String[] args) {
        String s = newList(); // Why does it compile?
    }
}
