package com.felipe.solidgof.discount;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import com.felipe.solidgof.model.Order;

public final class PercentageDiscount implements DiscountPolicy {
    private final BigDecimal rate; // 0.10 = 10%

    public PercentageDiscount(BigDecimal rate) {
        this.rate = Objects.requireNonNull(rate, "rate");
        if (rate.signum() < 0 || rate.compareTo(BigDecimal.ONE) > 0) {
            throw new IllegalArgumentException("rate must be between 0 and 1");
        }
    }

    @Override
    public BigDecimal discountFor(BigDecimal subtotal, Order order) {
        return subtotal.multiply(rate).setScale(2, RoundingMode.HALF_UP);
    }
}
