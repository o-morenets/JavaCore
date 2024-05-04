package _23_java_8_features._99_samples.orders_items;

import java.util.List;

public class Order {

	String id;
	List<Item> items;

	public Order(String id, List<Item> items) {
		this.id = id;
		this.items = items;
	}

	public String getId() {
		return id;
	}

	public List<Item> getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "Order{" +
				"id='" + id + '\'' +
				", items=" + items +
				'}';
	}
}
