package stackOverflow.customersJava8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class InvoiceData {

    static final Vendor vendor = Vendor.getInstance();

    private List<Invoice> orders;
    private List<Customer> customers;
//    private Map<String, Item> items;
    private Map<String, List<Item>> items;

    public List<Invoice> getOrders() {
        return orders;
    }

    public InvoiceData() {
        orders = formOrders();
    }

    //...сustomerSupplier, itemSupplier...
    private Supplier<List<Customer>> customerSupplier;
//    private Supplier<Map<String, Item>> itemSupplier;
    private Supplier<Map<String, List<Item>>> itemSupplier;

    public List<Invoice> formOrders() {

        List<Invoice> orders = new ArrayList<>();  //лист заказов, сюда собственно будут собираться объекты Invoice
        customers = customerSupplier.get(); //покупатели
        items = itemSupplier.get(); //товары

        customers.forEach(customer -> {

            Invoice invoice = new Invoice();
            orders.add(invoice);

            invoice.setVendor(vendor);
            invoice.setRecipient(customer);
            invoice.setTax(0.2);

//            invoice.setItems(items.entrySet().stream()
//                    .filter(item -> item.getKey().equals(customer.getId()))
//                    .map(Map.Entry::getValue)
//                    .collect(Collectors.toList()));

            invoice.setItems(items.get(customer.getId()));
        });

        return orders;
    }
}