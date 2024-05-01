package stackOverflow.timer;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Shedule {

    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now().plusSeconds(3);

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("run");
                timer.cancel();
            }
        }, Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant()));
    }
}
