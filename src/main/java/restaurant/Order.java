package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<String> orderedDishes = new ArrayList<>();

    public static Order createOrder() {
        return new Order();
    }

    public void addDish(String dishName) {
        orderedDishes.add(dishName);
    }

    public List<String> getOrderedDishes() {
        return orderedDishes;
    }

    public Rate discount() {
        Rate discount;
        if (getOrderedDishes().size() >= 10) {
            discount = Rate.discountPercent("10");
        } else {
            discount = Rate.fully();
        }
        return discount;
    }
}
