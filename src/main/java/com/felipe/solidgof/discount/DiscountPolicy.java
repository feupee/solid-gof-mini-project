package com.felipe.solidgof.discount;

import java.math.BigDecimal;

import com.felipe.solidgof.model.Order;

/**
 * Strategy: different discount rules implement this interface.
 * OCP: add a new discount rule by creating a new class (no core code changes).
 */
public interface DiscountPolicy {
    BigDecimal discountFor(BigDecimal subtotal, Order order);
}
