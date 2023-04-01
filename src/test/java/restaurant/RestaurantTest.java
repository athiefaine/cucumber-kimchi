package restaurant;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/restaurant.feature"},
        plugin = { "pretty", "html:target/cucumber/cucumber-html-report.html","json:target/cucumber/cucumber.json" }
)
public class RestaurantTest {

}
