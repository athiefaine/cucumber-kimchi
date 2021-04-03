package restaurant;

public class OrderLine {

    private Dish dish;

    private Integer quantity;

    public OrderLine(Dish dish, Integer quantity) {
        this.dish = dish;
        this.quantity = quantity;
    }

    public Dish getDish() {
        return dish;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public Double getAmount() {
        return dish.getPrice() * quantity;
    }
}
