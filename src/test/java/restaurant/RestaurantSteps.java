package restaurant;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantSteps {

    private final Map<String, BigDecimal> dishToPrice = new HashMap<>();
    private final List<String> orderedDishes = new ArrayList<>();
    private BigDecimal billingTotal;

    @Given("the menu contains the following dishes")
    public void theMenuContainsTheFollowingDishes(DataTable dataTable) {
        dataTable.asMaps().forEach(
                row -> dishToPrice.put(
                        row.get("name"),
                        new BigDecimal(row.get("price"))));
    }

    @And("the customer ordered {int} {string}")
    public void theCustomerOrdered(int quantity, String dish) {
        for (int i = 0; i < quantity; i++) {
            orderedDishes.add(dish);
        }
    }

    @When("the waiter computes the bill")
    public void theWaiterComputesTheBill() {
        billingTotal = BigDecimal.ZERO;
        for (String orderedDish : orderedDishes) {
            billingTotal = billingTotal.add(
                    dishToPrice.get(orderedDish));
        }
    }

    @Then("the bill amount should be {string}")
    public void theBillAmountShouldBe(String expectedTotal) {
        Assertions.assertThat(billingTotal).isEqualTo(new BigDecimal(expectedTotal));
    }
}
