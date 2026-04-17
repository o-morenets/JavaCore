package seat_reservation;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 17.04.2026
 *
 * Interview - Coherent Solutions
 */
public class SeatReservation {

    private static class Seat {
        private int row;
        private int number;

        public Seat(int row, int number) {
            this.row = row;
            this.number = number;
        }

        public int getRow() { return row; }
        public int getNumber() { return number; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Seat)) return false;
            Seat seat = (Seat) o;
            return row == seat.row && number == seat.number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, number);
        }
    }

    private final ConcurrentMap<Seat, String> reservations = new ConcurrentHashMap<>();

    public boolean reserve(Seat seat, String userId) {
        // атомарно: тільки перший потік вставить значення
        return reservations.putIfAbsent(seat, userId) == null;
    }

    public boolean cancel(Seat seat, String userId) {
        // remove(key, value) — теж атомарна операція
        return reservations.remove(seat, userId);
    }

    public boolean isReserved(Seat seat) {
        return reservations.containsKey(seat);
    }

    public String reservedBy(Seat seat) {
        return reservations.get(seat);
    }
}
