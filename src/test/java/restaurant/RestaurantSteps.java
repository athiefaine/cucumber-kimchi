package restaurant;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.math.BigDecimal;

public class RestaurantSteps {
    @Given("the menu contains the following dishes")
    public void theMenuContainsTheFollowingDishes(DataTable dataTable) {
    }

    @And("the customer ordered {int} {string}")
    public void theCustomerOrdered(int quantity, String dish) {
    }

    @When("the waiter computes the bill")
    public void theWaiterComputesTheBill() {
    }

    @Then("the bill amount should be {string}")
    public void theBillAmountShouldBe(String expectedTotal) {
        BigDecimal billingTotal = BigDecimal.ZERO;
        Assertions.assertThat(billingTotal).isEqualTo(new BigDecimal(expectedTotal));
    }
}
