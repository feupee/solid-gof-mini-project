package com.felipe.solidgof.payment;

import java.math.BigDecimal;
import java.util.UUID;

import com.felipe.solidgof.model.Order;

public final class BoletoPayment implements PaymentMethod {
    @Override
    public String name() {
        return "BOLETO";
    }

    @Override
    public String pay(BigDecimal amount, Order order) {
        // simulation only
        return "BOLETO-" + UUID.randomUUID();
    }
}
