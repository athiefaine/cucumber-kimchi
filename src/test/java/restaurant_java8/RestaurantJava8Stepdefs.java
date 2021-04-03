package restaurant_java8;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java8.En;
import org.junit.Assert;


import restaurant.Dish;
import restaurant.OrderHelper;

import java.util.Map;

public class RestaurantJava8Stepdefs implements En {

	private final ObjectMapper objectMapper = new ObjectMapper();
	
	OrderHelper orderHelper;
	
	public RestaurantJava8Stepdefs() {
		Given("the menu contains the following dishes", (final DataTable dishes) -> {
			orderHelper = new OrderHelper(dishes.asList(Dish.class));
		});
		Given("the customer ordered {int} {word}", (final Integer quantity, final String dishName) -> {
			orderHelper.orderDish(dishName, quantity);
		});
		When("the waiter computes the bill", () -> {
			orderHelper.computeBill();
		});
		Then("the bill amount should be {double}", (final Double amount) -> {
			Assert.assertEquals(amount, orderHelper.getAmount());
		});

	}

	@DataTableType
	public Dish toDish(Map<String, String> entry) {
		return objectMapper.convertValue(entry, Dish.class);
	}
	
}
