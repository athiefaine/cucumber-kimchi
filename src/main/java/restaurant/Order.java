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

    public List<String> orderedDishes() {
        return orderedDishes;
    }

    public Rate discount() {
        Rate discount;
        if (orderedDishes().size() >= 10) {
            discount = Rate.discountPercent("10");
        } else {
            discount = Rate.fully();
        }
        return discount;
    }

    public List<String> offeredDishes() {
        // TODO : refactor, improve concept of offered dish
        long orderedGyoza = orderedDishes.stream()
                .filter("gyoza"::equals)
                .count();
        long offeredGyoza = orderedGyoza / 3;
        List<String> offeredDishes = new ArrayList<>();
        for (long i = 0; i < offeredGyoza; i++) {
            offeredDishes.add("gyoza");
        }
        return offeredDishes;
    }
}
