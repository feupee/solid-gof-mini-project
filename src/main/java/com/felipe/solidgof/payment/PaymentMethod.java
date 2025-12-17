package com.felipe.solidgof.payment;

import java.math.BigDecimal;
import com.felipe.solidgof.model.Order;

/**
 * Strategy: different payment methods implement this interface.
 */
public interface PaymentMethod {
    String name();
    String pay(BigDecimal amount, Order order);
}
