package com.manu.solid.SRP.BadCode;

class PaymentService {
    public void processPayment(String paymentType, double amount) {
        if (paymentType.equals("CreditCard")) {
            System.out.println("Processing credit card payment of $" + amount);
        } else if (paymentType.equals("PayPal")) {
            System.out.println("Processing PayPal payment of $" + amount);
        } else if (paymentType.equals("BankTransfer")) {
            System.out.println("Processing BankTransfer payment of $" + amount);
        } else {
            System.out.println("Unsupported payment method");
        }
    }

    public void generateReceipt(double amount) {
        System.out.println("Generating receipt for $" + amount);
    }

    public void sendNotification(String message) {
        System.out.println("Sending notification: " + message);
    }
}