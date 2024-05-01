package epam._2019_11_08_interview_refinitiv;

import java.util.*;
import java.util.stream.Collectors;

public class FilterCustomers {

    public static void main(String[] args) {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer(5, "Bob 5"));
        customerList.add(new Customer(2, "Bob 2"));
        customerList.add(new Customer(4, "Bob 4"));
        customerList.add(new Customer(2, "Bob 2 dup"));
        customerList.add(new Customer(7, "Bob 7"));
        customerList.add(new Customer(6, "Bob 6"));
        customerList.add(new Customer(4, "Bob 4 dup"));

        // customers without duplicates
        System.out.println("---------------------------");
        Set<Customer> customerSet = new HashSet<>(customerList);
        List<Customer> distinctCustomers = new ArrayList<>(customerSet);
        distinctCustomers.forEach(System.out::println);

        // customers without duplicates in same order
        System.out.println("---------------------------");
        Set<Customer> customerSetOrdered = new LinkedHashSet<>(customerList);
        List<Customer> distinctCustomersOrdered = new ArrayList<>(customerSetOrdered);
        distinctCustomersOrdered.forEach(System.out::println);
    }
}

class Customer {
    private int custNo;
    private String name;

    public Customer(int custNo, String name) {
        this.custNo = custNo;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return custNo == customer.custNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(custNo);
    }

    @Override
    public String toString() {
        return "Customer{" + "custNo=" + custNo + ", name='" + name + '\'' + '}';
    }
}