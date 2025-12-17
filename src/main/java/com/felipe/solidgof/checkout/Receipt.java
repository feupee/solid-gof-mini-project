package com.felipe.solidgof.checkout;

import java.math.BigDecimal;
import java.util.Objects;

public final class Receipt {
    private final String orderId;
    private final BigDecimal subtotal;
    private final BigDecimal discount;
    private final BigDecimal total;
    private final String paymentMethod;
    private final String paymentReference;

    public Receipt(
            String orderId,
            BigDecimal subtotal,
            BigDecimal discount,
            BigDecimal total,
            String paymentMethod,
            String paymentReference
    ) {
        this.orderId = Objects.requireNonNull(orderId, "orderId");
        this.subtotal = Objects.requireNonNull(subtotal, "subtotal");
        this.discount = Objects.requireNonNull(discount, "discount");
        this.total = Objects.requireNonNull(total, "total");
        this.paymentMethod = Objects.requireNonNull(paymentMethod, "paymentMethod");
        this.paymentReference = Objects.requireNonNull(paymentReference, "paymentReference");
    }

    public String orderId() { return orderId; }
    public BigDecimal subtotal() { return subtotal; }
    public BigDecimal discount() { return discount; }
    public BigDecimal total() { return total; }
    public String paymentMethod() { return paymentMethod; }
    public String paymentReference() { return paymentReference; }

    @Override
    public String toString() {
        return "Order: " + orderId + "\n"
                + "Subtotal: " + subtotal + "\n"
                + "Discount: -" + discount + "\n"
                + "Total: " + total + "\n"
                + "Payment: " + paymentMethod + " (" + paymentReference + ")";
    }
}
