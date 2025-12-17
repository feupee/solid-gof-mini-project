package com.felipe.solidgof.discount;

import java.math.BigDecimal;
import com.felipe.solidgof.model.Order;

public final class NoDiscount implements DiscountPolicy {
    @Override
    public BigDecimal discountFor(BigDecimal subtotal, Order order) {
        return BigDecimal.ZERO;
    }
}
