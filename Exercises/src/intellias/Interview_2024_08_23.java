//package intellias;
//
//import java.util.List;
//
//public class Interview_2024_08_23 {
//
//    class Customer {
//        Integer id;
//        String name;
//        //getters, setters
//    }
//
//    class Order {
//        Integer id;
//        Integer customerId;
//        String orderInformation;
//        //getters, setters
//    }
//
//    class Statistic {
//        Integer orderId;
//        String customerName;
//        String orderInformation;
//        //getters, setters
//    }
//
//    public class OrderProcessor {
//
//        public List<Statistic> processOrders(List<Customer> customers, List<Order> orders) {
//            return orders.stream()
//                    .map(order -> {
//                        if(exists) {
//                            new Statistic(order.getId(), getCustomerName(customers, order), order.getOrderInformation()))
//                        }}
//
//                            .toList();
//        }
//
//        private Customer getCustomer(List<Customer> customers, Order order) {
//            for(Customer customer: customers) {
//                if (customer.getId().equals(order.getCustomerId()) {
//                    return customer;
//                }
//            }
//            return null;
//        }
//
//        private String getCustomerName(List<Customer> customers, Order order) {
//            for(Customer customer: customers) {
//                if (customer.getId().equals(order.getCustomerId()) {
//                    return customer.getName();
//                }
//            }
//            return null;
//        }
//    }
//
//}
