# Mini Projeto SOLID + GoF (Java)

Projeto Java pequeno e **amigável para entrevistas**, feito para demonstrar **POO**, princípios **SOLID** e padrões **GoF** (Strategy, Factory, Singleton) em um cenário simples de **checkout**.

## Objetivo
Mostrar na prática como estruturar um código **limpo, modular e fácil de manter**, usando:
- **SOLID**: SRP, OCP, DIP (com separação de responsabilidades e dependência por abstrações)
- **GoF**: **Strategy**, **Factory (simple factory)**, **Singleton**
- **Testes unitários** com **JUnit 5**

---

## O que a aplicação faz
Simula um checkout básico:
1. Monta um `Order` com itens (`Item`)
2. Calcula subtotal e aplica uma `DiscountPolicy` (**Strategy**)
3. Seleciona um `PaymentMethod` via `PaymentFactory` (**Factory**)
4. Envia notificação via `Notifier` (**DIP**)
5. Persiste o pedido via `OrderRepository` (**DIP**)

---

## Tecnologias
- **Java 17**
- **Maven**
- **JUnit 5**

---

## Como executar

### Pré-requisitos
- Java 17 instalado (`java -version`)
- Maven instalado (`mvn -version`)

### Rodar testes
```bash
mvn test
