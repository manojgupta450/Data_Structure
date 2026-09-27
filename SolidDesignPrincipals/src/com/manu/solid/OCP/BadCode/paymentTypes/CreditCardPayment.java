package com.manu.solid.OCP.BadCode.paymentTypes;

public class CreditCardPayment {
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of " + amount);
    }
}

