package com.felipe.solidgof;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.felipe.solidgof.checkout.CheckoutService;
import com.felipe.solidgof.discount.NoDiscount;
import com.felipe.solidgof.discount.PercentageDiscount;
import com.felipe.solidgof.model.Item;
import com.felipe.solidgof.model.Order;
import com.felipe.solidgof.notification.Notifier;
import com.felipe.solidgof.payment.PaymentFactory;
import com.felipe.solidgof.repository.InMemoryOrderRepository;

class CheckoutServiceTest {

    @Test
    void appliesPercentageDiscountAndPays() {
        var repo = new InMemoryOrderRepository();
        var notifier = new RecordingNotifier();

        var service = new CheckoutService(repo, notifier);

        var order = new Order("T-1");
        order.addItem(new Item("A", new BigDecimal("100.00")));
        order.addItem(new Item("B", new BigDecimal("50.00")));

        var discount = new PercentageDiscount(new BigDecimal("0.10")); // 15.00
        var payment = PaymentFactory.create("credit_card");

        var receipt = service.checkout(order, discount, payment);

        assertEquals(new BigDecimal("150.00"), receipt.subtotal());
        assertEquals(new BigDecimal("15.00"), receipt.discount());
        assertEquals(new BigDecimal("135.00"), receipt.total());
        assertEquals(1, repo.count());
        assertTrue(notifier.lastMessage().contains("Checkout completed"));
    }

    @Test
    void noDiscountKeepsTotalEqualSubtotal() {
        var service = new CheckoutService(new InMemoryOrderRepository(), new RecordingNotifier());

        var order = new Order("T-2");
        order.addItem(new Item("X", new BigDecimal("20.00")));

        var receipt = service.checkout(order, new NoDiscount(), PaymentFactory.create("pix"));

        assertEquals(new BigDecimal("20.00"), receipt.total());
    }

    private static final class RecordingNotifier implements Notifier {
        private String last;

        @Override
        public void notify(String message) {
            last = message;
        }

        public String lastMessage() {
            return last == null ? "" : last;
        }
    }
}
