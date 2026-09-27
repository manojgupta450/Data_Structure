
package com.manu.solid.SRP.GoodCode;

public class SRPDemo {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        ReceiptGenerator receipt = new ReceiptGenerator();
        NotificationService notification = new NotificationService();

        PaymentService paymentService = new PaymentService(processor, receipt, notification);
        paymentService.makePayment("CreditCard", 100.0);
    }
}