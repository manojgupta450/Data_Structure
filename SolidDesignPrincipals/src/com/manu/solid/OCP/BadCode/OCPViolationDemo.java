package com.manu.solid.OCP.BadCode;

import com.manu.solid.OCP.BadCode.processor.PaymentProcessor;

public class OCPViolationDemo {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment("CreditCard", 100.0);
        processor.processPayment("PayPal", 200.0);
        processor.processPayment("BankTransfer", 300.0);
    }
}