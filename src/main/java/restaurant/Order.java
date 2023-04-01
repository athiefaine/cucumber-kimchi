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
}
