package restaurant;

import java.math.BigDecimal;
import java.util.HashMap;

public class Menu {

    private final HashMap<String, BigDecimal> dishToPrice = new HashMap<>();

    static Menu createMenu() {
        return new Menu();
    }

    public void addDish(String dishName, BigDecimal dishPrice) {
        dishToPrice.put(dishName, dishPrice);
    }

    public BigDecimal findPriceForDish(String dishName) {
        return dishToPrice.get(dishName);
    }
}
