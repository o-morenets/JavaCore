package _20_multithreading._08_race_condition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CheckThenActExample {

    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        CheckThenActExample checkThenActExample = new CheckThenActExample();

        Runnable runnable = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                checkThenActExample.checkThenAct(map);
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    // synchronized prevents race condition of type check-then-act
    public /*synchronized*/ void checkThenAct(Map<String, String> sharedMap) {
        if (sharedMap.containsKey("key")) {
            String val = sharedMap.remove("key");
            if (val == null) {
                System.out.println("Value for 'key' was null");
            }
        } else {
            sharedMap.put("key", "value");
        }
    }
}
