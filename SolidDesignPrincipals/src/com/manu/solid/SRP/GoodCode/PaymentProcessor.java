package com.manu.solid.SRP.GoodCode;

// Handles only payment processing
class PaymentProcessor {
    public void processPayment(String paymentType, double amount) {
        System.out.println("Processing " + paymentType + " payment of $" + amount);
    }
}

