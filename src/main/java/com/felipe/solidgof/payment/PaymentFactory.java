package com.felipe.solidgof.payment;

import java.util.Locale;

/**
 * Factory (simple factory style): creates PaymentMethod instances.
 * OCP: to add a new payment method, add a new class + extend this factory mapping.
 * (In a bigger system you'd use DI/registration to avoid editing the factory.)
 */
public final class PaymentFactory {
    private PaymentFactory() {}

    public static PaymentMethod create(String type) {
        if (type == null) {
            throw new IllegalArgumentException("type cannot be null");
        }
        String key = type.trim().toLowerCase(Locale.ROOT);
        return switch (key) {
            case "pix" -> new PixPayment();
            case "credit", "credit_card", "card" -> new CreditCardPayment();
            case "boleto" -> new BoletoPayment();
            default -> throw new IllegalArgumentException("Unknown payment type: " + type);
        };
    }
}
