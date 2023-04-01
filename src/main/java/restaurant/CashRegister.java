package restaurant;

import java.math.BigDecimal;

public class CashRegister {
    static BigDecimal computeBill(Order order, Menu menu) {
        BigDecimal billingTotal = BigDecimal.ZERO;
        for (String orderedDish : order.getOrderedDishes()) {
            billingTotal = billingTotal.add(
                    menu.findPriceForDish(orderedDish));
        }
        return billingTotal;
    }
}
