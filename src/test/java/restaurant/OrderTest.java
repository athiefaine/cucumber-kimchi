package restaurant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class OrderTest {


    @Test
    void with_2_gyozas_no_gyoza_offered() {
        Order order = Order.createOrder();
        for (int i = 0; i < 2; i++) {
            order.addDish("gyoza");

        }

        assertThat(order.offeredDishes()).isEmpty();
    }

    @ParameterizedTest(name = "Ordered {0} gyozas, thus {1} gyoza(s) offered")
    @CsvSource({
            "0, 0",
            "1, 0",
            "2, 0",
            "3, 1",
            "4, 1",
            "5, 1",
            "6, 2",
            "7, 2"
    })
    void with_x_gyozas_y_gyozas_offered(int ordered, int expectedOffered) {
        Order order = Order.createOrder();
        for (int i = 0; i < ordered; i++) {
            order.addDish("gyoza");

        }

        assertThat(order.offeredDishes()).hasSize(expectedOffered);
    }

}
