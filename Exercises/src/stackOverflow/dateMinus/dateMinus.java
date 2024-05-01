package stackOverflow.dateMinus;

import java.time.LocalDate;
import java.time.Period;

public class dateMinus {

    public static void main(String[] args) {
        Period period = Period.of(30, 0, 0);
        LocalDate localDate = LocalDate.now();
        LocalDate minus = localDate.minus(period);
        System.out.println("minus = " + minus); // minus = 1988-11-18
    }
}
