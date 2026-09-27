package com.manu.solid.SRP.BadCode;

public class SRPViolationDemo {

    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.processPayment("CreditCard", 100);
        paymentService.generateReceipt(100);
        paymentService.sendNotification("Payment completed");
    }
}
