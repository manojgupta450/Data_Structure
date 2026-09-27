package com.manu.solid.DIP.GoodCode;

class PayPalPayment implements PaymentMethod {
    @Override
    public void processPayment(int amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}
