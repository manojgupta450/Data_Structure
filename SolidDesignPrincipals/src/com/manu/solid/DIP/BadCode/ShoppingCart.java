package com.manu.solid.DIP.BadCode;

// High-level module (ShoppingCart) is tightly coupled with low-level modules (Payment classes)
class ShoppingCart {
    private CreditCardPayment creditCardPayment;
    private PayPalPayment payPalPayment;

    public ShoppingCart() {
        this.creditCardPayment = new CreditCardPayment(); // Direct dependency ❌
        this.payPalPayment = new PayPalPayment(); // Direct dependency ❌
    }

    public void checkout(String method, int amount) {
        if (method.equals("credit")) {
            creditCardPayment.pay(amount);
        } else if (method.equals("paypal")) {
            payPalPayment.pay(amount);
        } else {
            throw new UnsupportedOperationException("This payment mode is not supported");
        }
    }
}
