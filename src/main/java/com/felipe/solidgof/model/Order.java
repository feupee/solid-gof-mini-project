package com.felipe.solidgof.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Order {
    private final String id;
    private final List<Item> items = new ArrayList<>();

    public Order(String id) {
        this.id = Objects.requireNonNull(id, "id");
    }

    public String id() {
        return id;
    }

    public void addItem(Item item) {
        items.add(Objects.requireNonNull(item, "item"));
    }

    public List<Item> items() {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal subtotal() {
        return items.stream()
                .map(Item::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
