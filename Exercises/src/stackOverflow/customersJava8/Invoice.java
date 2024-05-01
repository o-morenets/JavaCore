package stackOverflow.customersJava8;

import java.math.BigDecimal;
import java.util.List;

public class Invoice {
    private Vendor vendor;
    private Customer recipient;
    private List<Item> items;
    private BigDecimal priceOverall;
    private Double tax;

    public Invoice() {
    }
    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public void setRecipient(Customer recipient) {
        this.recipient = recipient;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
