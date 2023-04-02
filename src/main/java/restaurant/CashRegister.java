package restaurant;

public class CashRegister {
    public static Amount computeBill(Order order, Menu menu) {
        return order.getOrderedDishes().stream()
                .map(menu::findPriceForDish)
                .reduce(Amount.nothing(), Amount::add);
    }

}
