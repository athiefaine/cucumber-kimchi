package restaurant;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {

    @Test
    public void add_two_amounts() {
        Amount amountAddition = new Amount("25.99").add(new Amount("59.99"));
        assertThat(amountAddition).isEqualTo(new Amount("85.98"));
    }

    @Test
    public void amount_nothing_is_addition_neutral_element() {
        Amount amount = new Amount("25.99");
        Amount amountAddition = amount.add(Amount.nothing());
        assertThat(amountAddition).isEqualTo(amount);
    }

    @Test
    public void subtract_two_amounts() {
        Amount amountAddition = new Amount("25.99").subtract(new Amount("10.99"));
        assertThat(amountAddition).isEqualTo(new Amount("15.00"));
    }

    @Test
    public void multiply_amount() {
        Amount amountAddition = new Amount("25.99").multiply(3);
        assertThat(amountAddition).isEqualTo(new Amount("77.97"));
    }

}
