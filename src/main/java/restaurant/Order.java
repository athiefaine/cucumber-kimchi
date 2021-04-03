package restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {

    private List<OrderLine> orderLines = new ArrayList<>();

    public void addOrderLine(OrderLine orderLine) {
        this.orderLines.add(orderLine);
    }

    public Double getAmount() {
        return orderLines.stream()
                .map(OrderLine::getAmount)
                .mapToDouble(Double::doubleValue)
                .sum();
    }

}
