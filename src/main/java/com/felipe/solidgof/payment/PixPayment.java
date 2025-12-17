package com.felipe.solidgof.payment;

import java.math.BigDecimal;
import java.util.UUID;

import com.felipe.solidgof.model.Order;

public final class PixPayment implements PaymentMethod {
    @Override
    public String name() {
        return "PIX";
    }

    @Override
    public String pay(BigDecimal amount, Order order) {
        // simulation only
        return "PIX-" + UUID.randomUUID();
    }
}
