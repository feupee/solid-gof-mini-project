package com.felipe.solidgof.app;

import java.math.BigDecimal;

import com.felipe.solidgof.checkout.CheckoutService;
import com.felipe.solidgof.config.AppConfig;
import com.felipe.solidgof.discount.PercentageDiscount;
import com.felipe.solidgof.model.Item;
import com.felipe.solidgof.model.Order;
import com.felipe.solidgof.notification.ConsoleNotifier;
import com.felipe.solidgof.payment.PaymentFactory;
import com.felipe.solidgof.repository.InMemoryOrderRepository;

public class Main {
    public static void main(String[] args) {
        // Singleton usage (simple app settings)
        AppConfig config = AppConfig.getInstance();
        System.out.println("Environment: " + config.environment());

        // Build an order (domain model)
        Order order = new Order("ORDER-001");
        order.addItem(new Item("Haircut", new BigDecimal("60.00")));
        order.addItem(new Item("Beard trim", new BigDecimal("25.00")));

        // Compose the use-case (DIP: depend on abstractions, inject implementations)
        CheckoutService checkout = new CheckoutService(
                new InMemoryOrderRepository(),
                new ConsoleNotifier()
        );

        // Strategy (discount) + Factory (payment strategy)
        var discount = new PercentageDiscount(new BigDecimal("0.10")); // 10%
        var payment = PaymentFactory.create("pix");

        var receipt = checkout.checkout(order, discount, payment);

        System.out.println("\n--- RECEIPT ---");
        System.out.println(receipt);
    }
}
