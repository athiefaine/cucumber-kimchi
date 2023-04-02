package restaurant;

import java.math.BigDecimal;

public class CashRegister {
    public static Amount computeBill(Order order, Menu menu) {
        Amount total = order.getOrderedDishes().stream()
                .map(menu::findPriceForDish)
                .reduce(Amount.nothing(), Amount::add);
        if (order.getOrderedDishes().size() >= 10) {
            total = new Amount(total.toBigDecimal().multiply(BigDecimal.ONE.subtract(new BigDecimal("0.10"))));
        }
        return total;
    }

}
