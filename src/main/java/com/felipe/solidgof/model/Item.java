package com.felipe.solidgof.model;

import java.math.BigDecimal;
import java.util.Objects;

public final class Item {
    private final String name;
    private final BigDecimal price;

    public Item(String name, BigDecimal price) {
        this.name = Objects.requireNonNull(name, "name");
        this.price = Objects.requireNonNull(price, "price");
        if (price.signum() < 0) {
            throw new IllegalArgumentException("price must be >= 0");
        }
    }

    public String name() {
        return name;
    }

    public BigDecimal price() {
        return price;
    }
}
