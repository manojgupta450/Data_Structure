package com.manu.solid.DIP.GoodCode;

public class DIPExample {
    public static void main(String[] args) {
        PaymentMethod paymentMethod = new CreditCardPayment(); // Can be replaced with any payment method
        ShoppingCart cart = new ShoppingCart(paymentMethod);
        cart.checkout(100); // Output: Paid 100 using Credit Card.

        // Switching to another payment method without modifying ShoppingCart
        PaymentMethod anotherPaymentMethod = new PayPalPayment();
        ShoppingCart anotherCart = new ShoppingCart(anotherPaymentMethod);
        anotherCart.checkout(200); // Output: Paid 200 using PayPal.
    }
}
