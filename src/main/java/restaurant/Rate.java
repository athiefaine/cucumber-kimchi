package restaurant;

import lombok.Value;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Value
public class Rate {

    BigDecimal value;

    public Rate(String value) {
        this.value = new BigDecimal(value).setScale(3, RoundingMode.HALF_DOWN);
    }

    public Rate(BigDecimal value) {
        this.value = value.setScale(3, RoundingMode.HALF_DOWN);
    }

    public Rate(Rate other) {
        this.value = BigDecimal.ZERO.add(other.value);
    }

    public static Rate fully() {
        return new Rate(BigDecimal.ONE);
    }

    public static Rate discountPercent(String discountPercent) {
        return Rate.fully().subtract(new Rate(discountPercent).multiply(new Rate("0.01")));
    }

    public Amount apply(Amount amount) {
        return new Amount(amount.toBigDecimal().multiply(this.value));
    }

    public Rate add(Rate other) {
        return new Rate(this.value.add(other.value));
    }

    public Rate multiply(Rate other) {
        return new Rate(this.value.multiply(other.value));
    }

    public Rate subtract(Rate other) {
        return new Rate(this.value.subtract(other.value));
    }

    public BigDecimal asBigDecimal() {
        return value;
    }
}
