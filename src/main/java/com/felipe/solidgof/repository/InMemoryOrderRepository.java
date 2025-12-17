package com.felipe.solidgof.repository;

import java.util.ArrayList;
import java.util.List;

import com.felipe.solidgof.model.Order;

public final class InMemoryOrderRepository implements OrderRepository {
    private final List<Order> saved = new ArrayList<>();

    @Override
    public void save(Order order) {
        saved.add(order);
        System.out.println("[REPO] Saved order " + order.id());
    }

    public int count() {
        return saved.size();
    }
}
