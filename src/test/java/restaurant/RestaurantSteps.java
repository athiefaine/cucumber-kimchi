package restaurant;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

public class RestaurantSteps {

    private final Menu menu = Menu.createMenu();

    private final Order order = Order.createOrder();

    private Amount billingTotal;


    @Given("the menu contains the following dishes")
    public void theMenuContainsTheFollowingDishes(DataTable dataTable) {
        dataTable.asMaps().forEach(
                row -> menu.addDish(
                        row.get("name"),
                        new Amount(row.get("price"))));
    }

    @And("the customer ordered {int} {string}")
    public void theCustomerOrdered(int quantity, String dish) {
        for (int i = 0; i < quantity; i++) {
            order.addDish(dish);
        }
    }

    @When("the waiter computes the bill")
    public void theWaiterComputesTheBill() {
        billingTotal = CashRegister.computeBill(order, menu);
    }

    @Then("the bill amount should be {string}")
    public void theBillAmountShouldBe(String expectedTotal) {
        Assertions.assertThat(billingTotal).isEqualTo(new Amount(expectedTotal));
    }
}
