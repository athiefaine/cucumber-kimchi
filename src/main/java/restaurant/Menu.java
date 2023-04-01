package restaurant;

import java.util.HashMap;

public class Menu {

    private final HashMap<String, Amount> dishToPrice = new HashMap<>();

    static Menu createMenu() {
        return new Menu();
    }

    public void addDish(String dishName, Amount dishPrice) {
        dishToPrice.put(dishName, dishPrice);
    }

    public Amount findPriceForDish(String dishName) {
        return dishToPrice.get(dishName);
    }

}
