package restaurant;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class RestaurantSteps {

	private final ObjectMapper objectMapper = new ObjectMapper();
	
	OrderHelper orderHelper;
	
	@Given("the menu contains the following dishes")
	public void the_menu_contains_the_following_dishes(final List<Dish> dishes) {
		orderHelper = new OrderHelper(dishes);
	}
	
	@Given("the customer ordered {int} {word}")
	public void the_customer_order(final Integer quantity, final String dishName) {
		orderHelper.orderDish(dishName, quantity);
	}

	@When("the waiter computes the bill")
	public void the_waiter_computes_the_bill() {
		orderHelper.computeBill();
	}

	
	@Then("the bill amount should be {double}")
	public void the_order_amount_should_be(final Double amount) {
		Assert.assertEquals(amount, orderHelper.getAmount());
	}

	@DataTableType
	public Dish toDish(Map<String, String> entry) {
		return objectMapper.convertValue(entry, Dish.class);
	}

}
