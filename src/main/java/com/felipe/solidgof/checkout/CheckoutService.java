package com.felipe.solidgof.checkout;

import java.math.BigDecimal;
import java.util.Objects;

import com.felipe.solidgof.discount.DiscountPolicy;
import com.felipe.solidgof.model.Order;
import com.felipe.solidgof.notification.Notifier;
import com.felipe.solidgof.payment.PaymentMethod;
import com.felipe.solidgof.repository.OrderRepository;

/**
 * SRP: Orchestrates the checkout use-case (doesn't implement discount/payment rules).
 * DIP: Depends on abstractions (OrderRepository, Notifier).
 */
public final class CheckoutService {
    private final OrderRepository repository;
    private final Notifier notifier;

    public CheckoutService(OrderRepository repository, Notifier notifier) {
        this.repository = Objects.requireNonNull(repository, "repository");
        this.notifier = Objects.requireNonNull(notifier, "notifier");
    }

    public Receipt checkout(Order order, DiscountPolicy discountPolicy, PaymentMethod paymentMethod) {
        Objects.requireNonNull(order, "order");
        Objects.requireNonNull(discountPolicy, "discountPolicy");
        Objects.requireNonNull(paymentMethod, "paymentMethod");

        BigDecimal subtotal = order.subtotal();
        BigDecimal discount = discountPolicy.discountFor(subtotal, order);
        if (discount.signum() < 0) {
            throw new IllegalStateException("discount cannot be negative");
        }
        if (discount.compareTo(subtotal) > 0) {
            discount = subtotal;
        }
        BigDecimal total = subtotal.subtract(discount);

        String paymentRef = paymentMethod.pay(total, order);

        repository.save(order);

        notifier.notify("Checkout completed for " + order.id()
                + " | total=" + total
                + " | via " + paymentMethod.name());

        return new Receipt(order.id(), subtotal, discount, total, paymentMethod.name(), paymentRef);
    }
}
