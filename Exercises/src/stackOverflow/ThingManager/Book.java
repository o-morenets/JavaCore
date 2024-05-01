
package stackOverflow.ThingManager;

public class Book extends Thing {
    long internationalBookNumber;                                //в расшифровке ISBN жалуется на Standart

    Book(long internationalBookNumber, String place, String size) {
        super(place, size);
        this.internationalBookNumber = internationalBookNumber;
    }

    long getInternationalBookNumber() {
        return internationalBookNumber;
    }

    void setInternationalBookNumber(long internationalBookNumber) {
        this.internationalBookNumber = internationalBookNumber;
    }

    @Override
    public String toString() {
        return "K`nigga: " + internationalBookNumber ;
    }
}