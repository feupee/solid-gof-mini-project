# SOLID + GoF Mini Project (Java)

A small, **interview-friendly** Java project to demonstrate:
- **SOLID** (SRP, OCP, DIP + clean layering)
- **GoF patterns**: **Strategy**, **Factory Method** (simple factory), **Singleton**

## What the app does
Simulates a simple **checkout**:
1. Builds an `Order` with items
2. Applies a `DiscountPolicy` (**Strategy**)
3. Chooses a `PaymentMethod` via `PaymentFactory` (**Factory**)
4. Sends a notification via a `Notifier` abstraction (**DIP**)
5. Saves to an `OrderRepository` abstraction (**DIP**)

## Tech
- Java 17
- Maven
- JUnit 5

## Run
```bash
mvn test
mvn -q exec:java
```

## Quick mapping (talking points)
- **SRP**: `CheckoutService` orchestrates the flow; pricing/discount/payment/notification are delegated.
- **OCP**: add new discounts or payment methods by creating new classes implementing interfaces—no changes needed in core rules.
- **DIP**: `CheckoutService` depends on abstractions (`Notifier`, `OrderRepository`), not concrete implementations.
- **Strategy**: `DiscountPolicy`, `PaymentMethod`
- **Factory**: `PaymentFactory.create(...)` returns the appropriate strategy
- **Singleton**: `AppConfig` centralizes simple settings

## Resume bullet example
“Built a Java mini-system applying **SOLID** and **GoF patterns** (Strategy, Factory, Singleton), using abstractions (DIP) and unit tests (JUnit) to validate behavior.”
