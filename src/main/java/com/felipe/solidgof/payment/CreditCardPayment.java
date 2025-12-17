package com.felipe.solidgof.payment;

import java.math.BigDecimal;
import java.util.UUID;

import com.felipe.solidgof.model.Order;

public final class CreditCardPayment implements PaymentMethod {
    @Override
    public String name() {
        return "CREDIT_CARD";
    }

    @Override
    public String pay(BigDecimal amount, Order order) {
        // simulation only
        return "CC-" + UUID.randomUUID();
    }
}
