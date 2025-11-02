package misc;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Loyal is the customer who:
 * a) visited at least 2 different pages
 * b) visited a website on both days
 */
public class LoyalCustomer {

    record PageView(Integer customerId, Integer pageId) {
    }

    public static void main(String[] args) {
        System.out.println(getLoyalCustomers()); // [2, 5, 6]
    }

    static final Collection<PageView> DAY_ONE_VISITS = List.of(
            new PageView(1, 1),
            new PageView(2, 1),
            new PageView(3, 2),
            new PageView(5, 3),
            new PageView(5, 4),
            new PageView(6, 1),
            new PageView(6, 2),
            new PageView(6, 3)
    );

    static final Collection<PageView> DAY_TWO_VISITS = List.of(
            new PageView(1, 1),
            new PageView(2, 3),
            new PageView(3, 2),
            new PageView(4, 4),
            new PageView(5, 1),
            new PageView(6, 2)
    );

    static Collection<Integer> getLoyalCustomers() {

        Collection<Integer> loyalCustomers = new ArrayList<>();

//        Set<Integer> day1Customers = DAY_ONE_VISITS.stream()
//                .map(PageView::customerId)
//                .collect(Collectors.toSet());
//
//        Set<Integer> day2Customers = DAY_TWO_VISITS.stream()
//                .map(PageView::customerId)
//                .collect(Collectors.toSet());
//
//        Set<Integer> bothDays = new HashSet<>(day1Customers);
//        bothDays.retainAll(day2Customers);
//
//        Map<Integer, Set<Integer>> pagesByCustomer =
//                Stream.concat(DAY_ONE_VISITS.stream(), DAY_TWO_VISITS.stream())
//                        .collect(Collectors.groupingBy(
//                                PageView::customerId,
//                                Collectors.mapping(PageView::pageId, Collectors.toSet())
//                        ));
//
//        return bothDays.stream()
//                .filter(id -> pagesByCustomer.getOrDefault(id, Set.of()).size() >= 2)
//                .sorted()
//                .collect(Collectors.toList());

        return loyalCustomers;
    }
}
