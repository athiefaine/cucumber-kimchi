package restaurant;

public class CashRegister {
    public static Amount computeBill(Order order, Menu menu) {
        Amount totalAmount = Amount.nothing();
        for (String orderedDish : order.getOrderedDishes()) {
            totalAmount = totalAmount.add(menu.findPriceForDish(orderedDish));
        }
        return totalAmount;
    }

}
