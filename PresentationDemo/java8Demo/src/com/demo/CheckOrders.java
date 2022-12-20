package com.demo;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckOrders {

	public static void main(String[] args) {

		Item item1 = new Item(134, "Moto24", 15000, "Mobiles");
		Item item2 = new Item(157, "Spiderman", 50, "Books");
		Item item3 = new Item(204, "Acer", 70000, "Laptops");
		Item item4 = new Item(210, "iPhone", 45000, "Mobiles");
		Item item5 = new Item(215, "Shirt", 1500, "Shirts");

		Customer c1 = new Customer(1, "Tom", "male", "Bangalore");
		Customer c2 = new Customer(2, "Mike", "male", "Delhi");
		Customer c3 = new Customer(3, "Miley", "female", "Pune");
		Customer c4 = new Customer(4, "Kunal", "male", "Delhi");
		Customer c5 = new Customer(5, "Sakshi", "female", "Delhi");

		Order o1 = new Order(1, "delivered", LocalDate.of(2021, 11, 12), LocalDate.of(2021, 11, 14),
				List.of(item1, item3), c1);
		Order o2 = new Order(2, "delivered", LocalDate.of(2022, 05, 19), LocalDate.of(2022, 05, 24), List.of(item3),
				c4);
		Order o3 = new Order(3, "delivered", LocalDate.of(2021, 07, 31), LocalDate.of(2021, Month.AUGUST, 04),
				List.of(item4, item5), c2);
		Order o4 = new Order(4, "pending", LocalDate.of(2022, 10, 29), null, List.of(item1, item2, item3, item5), c3);
		Order o5 = new Order(5, "pending", LocalDate.of(2021, 10, 30), null, List.of(item1), c5);

		List<Item> itemList = List.of(item1, item2, item3, item4, item5);
		List<Order> orderList = List.of(o1, o2, o3, o4, o5);

		List<Item> iList = findItemsAsMobiles(itemList);
		System.out.println("list of items belongs to category “Mobiles” " + iList.toString());
		findItemsAsMobileswithPrice(itemList);
		findMobileOrders(orderList);

		// Obtain a list of items with category “Laptops” and then apply 5% discount
		List<Item> newItemList = itemList;
		List<Item> laptopCategory = new ArrayList<Item>();
		newItemList.forEach(item -> {
			if (item.getCategory().equals("Laptops")) {
				item.setPrice(item.getPrice() - (item.getPrice() * 0.05));
				laptopCategory.add(item);
			}
		});
		System.out.println(
				"list of items with category “Laptops” and then apply 5% discount" + laptopCategory.toString());

		// Obtain a list of items ordered by customers who are female
		List<Item> orderedItems = new ArrayList<Item>();

		orderList.forEach(order -> {
			if (order.getCustomer().getGender().equals("female")) {
				orderedItems.addAll(order.getItems());
			}
		});
		System.out.println("list of items ordered by customers who are female " + orderedItems.toString());

		// Obtain a list of items ordered by customers between 01-Jan-2022 and
		// 31-Oct-2022
		List<Item> orderedItemsbetweenAPeriod = new ArrayList<Item>();

		orderList.forEach(order -> {
			LocalDate min = LocalDate.of(2022, 01, 01);
			LocalDate max = LocalDate.of(2022, 10, 31);
			if (order.getOrderDate().isBefore(max) && order.getOrderDate().isAfter(min)) {
				orderedItemsbetweenAPeriod.addAll(order.getItems());
			}
		});
		System.out.println("list of items ordered by customers between 01-Jan-2022 and 31-Oct-2022"
				+ orderedItemsbetweenAPeriod.toString());

	}

	// Obtain a list of items belongs to category “Mobiles”
	public static List<Item> findItemsAsMobiles(List<Item> itemList) {
		List<Item> mobileCategory = itemList.stream().filter(item -> item.getCategory().equals("Mobiles"))
				.collect(Collectors.toList());
		return mobileCategory;
	}
	// Obtain a list of items belongs to category “Mobiles” and price is greaterthan
	// 20000

	public static void findItemsAsMobileswithPrice(List<Item> itemList) {
		List<Item> mobileCategorywithPrice = itemList.stream().filter(item -> item.getCategory().equals("Mobiles"))
				.filter(item -> item.getPrice() > 20000).collect(Collectors.toList());
		System.out.println("list of items belongs to category “Mobiles” and price is greaterthan 20000"
				+ mobileCategorywithPrice.toString());
	}

	// Obtain a list of order with items category is not “Mobiles”
	public static void findMobileOrders(List<Order> orderList) {
		List<Order> ol = new ArrayList<>();
		ol.addAll(orderList);
		orderList.forEach(order -> {
			List<Item> il = new ArrayList<>();
			il = findItemsAsMobiles(order.getItems());
			if (il.size() > 0) {
				ol.remove(order);
			}
		});
		System.out.println("list of order with items category is not “Mobiles”" + ol.toString());

	}

}
