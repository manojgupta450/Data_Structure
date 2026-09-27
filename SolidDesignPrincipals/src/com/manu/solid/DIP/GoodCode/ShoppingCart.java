package com.manu.solid.DIP.GoodCode;

// Now ShoppingCart depends on PaymentMethod (abstraction) instead of concrete classes
class ShoppingCart {
    private PaymentMethod paymentMethod;

    // Dependency Injection via constructor
    public ShoppingCart(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void checkout(int amount) {
        paymentMethod.processPayment(amount);
    }
}