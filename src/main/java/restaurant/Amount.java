package restaurant;

import lombok.Value;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Value
public class Amount {

    BigDecimal value;

    public Amount(BigDecimal value) {
        this.value = value.setScale(2, RoundingMode.DOWN);
    }

    public Amount(String value) {
        this(new BigDecimal(value));
    }

    public static Amount nothing() {
        return new Amount(BigDecimal.ZERO);
    }

    Amount add(Amount other) {
        return new Amount(value.add(other.value));
    }

    public Amount apply(Rate rate) {
        return new Amount(this.value.multiply(rate.asBigDecimal()));
    }

    BigDecimal toBigDecimal() {
        return value;
    }
}
