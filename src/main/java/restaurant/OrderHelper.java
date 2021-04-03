package restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderHelper {
	private Map<String, Dish> dishes;

	private Order order = new Order();
	
	private Double amount = 0d;
	
	public OrderHelper(final List<Dish> dishes) {
		this.dishes = dishes.stream().collect(Collectors.toMap(Dish::getName, Function.identity()));
	}
	
	public void orderDish(String dishName, Integer quantity) {
		Dish dish = dishes.get(dishName);
		Double price = dish.getPrice();
		amount += price * quantity;
		order.addOrderLine(new OrderLine(dish, quantity));
	}

	public void computeBill() {
		amount = order.getAmount();
	}
	
	public Double getAmount() {
		return amount;
	}

}
