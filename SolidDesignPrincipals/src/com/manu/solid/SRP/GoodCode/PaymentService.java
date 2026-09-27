package com.manu.solid.SRP.GoodCode;

// High-level class that coordinates different services
class PaymentService {
    private final PaymentProcessor paymentProcessor;
    private final ReceiptGenerator receiptGenerator;
    private final NotificationService notificationService;

    public PaymentService(PaymentProcessor paymentProcessor, ReceiptGenerator receiptGenerator, NotificationService notificationService) {
        this.paymentProcessor = paymentProcessor;
        this.receiptGenerator = receiptGenerator;
        this.notificationService = notificationService;
    }

    public void makePayment(String paymentType, double amount) {
        paymentProcessor.processPayment(paymentType, amount);
        receiptGenerator.generateReceipt(amount);
        notificationService.sendNotification("Payment of $" + amount + " was successful.");
    }
}