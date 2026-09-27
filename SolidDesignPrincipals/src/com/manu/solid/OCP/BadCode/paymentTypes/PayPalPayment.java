package com.manu.solid.OCP.BadCode.paymentTypes;

public class PayPalPayment {
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of " + amount);
    }
}
