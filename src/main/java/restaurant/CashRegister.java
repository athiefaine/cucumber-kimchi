package restaurant;

public class CashRegister {
    public static Amount computeBill(Order order, Menu menu) {
        Amount offeredDishesAmount = order.offeredDishes().stream()
                .map(menu::findPriceForDish)
                .reduce(Amount.nothing(), Amount::add);

        return order.orderedDishes().stream()
                .map(menu::findPriceForDish)
                .reduce(Amount.nothing(), Amount::add)
                .subtract(offeredDishesAmount)
                .apply(order.discount());
    }

}
