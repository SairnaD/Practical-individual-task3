
package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private final List<Order> completedOrders = new ArrayList<>();

    public void save(Order order) {
        if (order == null || !order.isPaid()) {
            throw new IllegalArgumentException(
                    "Only paid orders can be saved."
            );
        }

        if (!completedOrders.contains(order)) {
            completedOrders.add(order);
        }
    }

    public List<Order> getCompletedOrders() {
        return List.copyOf(completedOrders);
    }
}
