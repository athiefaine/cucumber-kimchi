package restaurant;

public class CashRegister {
    public static Amount computeBill(Order order, Menu menu) {
        long orderedGyoza = order.getOrderedDishes().stream()
                .filter("gyoza"::equals)
                .count();
        long offeredGyoza = orderedGyoza / 3;

        return order.getOrderedDishes().stream()
                .map(menu::findPriceForDish)
                .reduce(Amount.nothing(), Amount::add)
                .subtract(menu.findPriceForDish("gyoza").multiply(offeredGyoza))
                .apply(order.discount());
    }

}
